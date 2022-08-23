package org.avant.basics.ds;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        mergeSort2(new int[]{1,2,3,0,0,0},3, new int[]{2,5,6},3);
        mergeSort2(new int[]{1},1, new int[]{},0);
        mergeSort2(new int[]{0},0, new int[]{1},1);
    }

    public static void mergeSort(int[] nums1, int m, int[] nums2, int n) {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //Output: [1,2,2,3,5,6]

        int[] fin = new int[m+n];

        if(m==0) fin=nums2;
        else if(n==0) fin=nums1;

        for (int i=0,j=0,k=0; i<=m && j<n && k<(m+n);k++) {
            if(i==m) {
               fin[k] = nums2[j];
               j++;
            }
            else if(nums1[i] > nums2[j]) {
                fin[k]=nums2[j];
                j++;
            } else {
                fin[k] = nums1[i];
                i++;
            }
        }
        System.out.println(Arrays.toString(fin));
    }
    public static void mergeSort2(int[] nums1, int m, int[] nums2, int n) {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //Output: [1,2,2,3,5,6]
        //[2,5,6,0,0,0] [1,2,3]
        //2, 2
        //6 > 3
        //[2,5,6,0,0,6] [1,2,3]
        //1, 2
        //5 > 3
        //[2,5,6,0,5,6] [1,2,3]
        //0,2
        //2 > 3 xx
        //[2,5,6,3,5,6] [1,2,3]
        //0,1
        //2 > 2 xx
        //[2,5,2,3,5,6] [1,2,3]
        //0,0
        //2> 1
        //[2,2,2,3,5,6] [1,2,3]
        //-1, 0
        //[1,2,2,3,5,6] [1,2,3]

        int x1 = m-1;
        int x2 = n-1;

        for (int i=m+n-1;i>=0; i--) {
            if(x2<0) break;
            if(x1>=0 && nums1[x1] > nums2[x2]) {
                nums1[i] = nums1[x1--];
            } else {
                nums1[i] = nums2[x2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

}
