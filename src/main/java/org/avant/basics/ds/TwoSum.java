package org.avant.basics.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] ex1Input = {2,7,11,15};
        int[] ex2Input = {3,2,4};
        int[] ex3Input = {3,3};

        System.out.println(Arrays.toString(twoSumUsingHash(ex1Input, 9)));
        System.out.println(Arrays.toString(twoSumUsingHash(ex2Input, 6)));
        System.out.println(Arrays.toString(twoSumUsingHash(ex3Input, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length <= 2) return new int[]{0,1};

        Arrays.sort(nums);
        //[2,17,7,15]
        //[2,7,15,17]
        int first=nums[0];
        int startIdx = 0;
        while(first<=target && startIdx < nums.length) {
            int search = target - first;
            for(int i=0; nums[i]<=search; i++) {
                if(nums[i]==search) return new int[]{startIdx,i};
            }
            first = nums[++startIdx];
        }

        return new int[]{};
    }
    public static int[] twoSumUsingHash(int[] nums, int target) {
        if(nums.length <= 2) return new int[]{0,1};

        //[3,2,4]
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++) {
            Integer probEndIdx = map.get(target-nums[i]);
            if(probEndIdx != null) return new int[] {probEndIdx, i};
            map.put(nums[i], i);
        }
        //now check last
        for(Map.Entry<Integer,Integer> key: map.entrySet()) {
            Integer probEndIdx = map.get(key.getKey());
            if(probEndIdx != null) return new int[] {key.getValue(), probEndIdx};
        }
        return new int[]{};
    }
}
