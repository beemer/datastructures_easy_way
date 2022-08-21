package org.avant.basics.ds;

import static java.lang.Math.max;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] ex1Input = {-2,1,-3,4,-1,2,1,-5,4};
        int[] ex2Input = {5,4,-1,7,8};
        int[] ex3Input = {-5,-4,-3,-2,-2};
        System.out.println("Kadane's Approach");
        System.out.println(sumSubArray(ex1Input));
        System.out.println(sumSubArray(ex2Input));
        System.out.println(sumSubArray(ex3Input));

        System.out.println("D&C Approach");
        MaximumSubarray ms = new MaximumSubarray();
        ms.numArray = ex1Input;
        System.out.println(ms.findBestSubArray(0, ms.numArray.length-1));

        ms.numArray = ex2Input;
        System.out.println(ms.findBestSubArray(0, ms.numArray.length-1));

        ms.numArray = ex3Input;
        System.out.println(ms.findBestSubArray(0, ms.numArray.length-1));
    }

    /*
        Kadane's Algorithm
     */
    public static int sumSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int currentSubArray = nums[0];
        int maxSubArray = nums[0];

        for(int i=1; i<nums.length; i++) {
            currentSubArray = max(nums[i],nums[i]+currentSubArray);
            maxSubArray = max(currentSubArray, maxSubArray);
        }

        return maxSubArray;
    }

    private int[] numArray;

    public int findBestSubArray(int left, int right) {
        if(left > right) return Integer.MIN_VALUE;
        int mid = Math.floorDiv(left + right, 2);

        int curr = 0;
        int bestLeftSum = 0;
        for(int i=mid-1; i >=left;i--) {
            curr += numArray[i];
            bestLeftSum = max(curr, bestLeftSum);
        }

        curr = 0;
        int bestRightSum = 0;
        for(int i=mid+1; i<=right; i++) {
            curr += numArray[i];
            bestRightSum = max(curr, bestRightSum);
        }

        int bestCombinedSum = numArray[mid] + bestLeftSum + bestRightSum;

        int leftHalfBestSum = findBestSubArray(left, mid-1);
        int rightHalfBestSum = findBestSubArray(mid+1, right);
        return max(bestCombinedSum, max(leftHalfBestSum, rightHalfBestSum));
    }
}
