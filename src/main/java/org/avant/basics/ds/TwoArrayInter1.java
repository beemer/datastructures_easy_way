package org.avant.basics.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoArrayInter1 {
    public static void main(String[] args) {
        inter(new int[]{1,2,2,1}, new int[]{2,2});
        inter(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        interUsingMap(new int[]{1,2,2,1}, new int[]{2,2});
        interUsingMap(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        interUsingMap(new int[]{1}, new int[]{1});
    }

    public static void inter(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int x1 = nums1.length-1;
        int x2 = nums2.length-1;

        int[] jo = new int[]{};

        int f1=0;

        while(x1 >=0 || x2 >=0) {
            if(x2 <0 || x1 <0) break;
            else if(nums1[x1]==nums2[x2]) {
                if(jo.length==0) {
                    jo = new int[1];
                    jo[f1] = nums1[x1];
                } else {
                    int newLen = jo.length+1;
                    int[] old = jo;
                    jo = new int[newLen];
                    for(int i=0; i<newLen-1; i++){
                        jo[i] = old[i];
                    }
                    jo[newLen-1] = nums1[x1];
                }
                x1--;x2--;
            } else if(nums1[x1] > nums2[x2]) {
                x1--;
            } else {
                x2--;
            }
        }

        System.out.println(Arrays.toString(jo));
    }
    public static int[] interUsingMap(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) {
            return interUsingMap(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums1) map.put(n,map.getOrDefault(n,0)+1);

        int x1=0;
        for (int n: nums2) {
            int cnt = map.getOrDefault(n,0);
            if(cnt > 0) {
                nums1[x1++] = n;
                map.put(n, cnt-1);
            }
        }
        int[] jo = Arrays.copyOf(nums1, x1);
        System.out.println(Arrays.toString(jo));
        return jo;
    }
}
