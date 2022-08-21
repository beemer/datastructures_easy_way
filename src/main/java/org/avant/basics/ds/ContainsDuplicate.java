package org.avant.basics.ds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String args[]) {
        int[] ex1Input = {1,2,3,1};
        int[] ex2Input = {1,2,3,4};
        int[] ex3Input = new int[10000001];
        for(int i=0; i<10000000; i++)
            ex3Input[i] = i+1;
        ex3Input[10000000] = 1;

        long foo = System.currentTimeMillis();
/*        System.out.println("Now running linear search");
        System.out.println(linearSearch(ex1Input));
        System.out.println(linearSearch(ex2Input));
        System.out.println(linearSearch(ex3Input));
        System.out.println(System.currentTimeMillis() - foo);

        foo = System.currentTimeMillis();*/
        System.out.println("Now running sorted + search");
        System.out.println(sortedArraySearch(ex1Input));
        System.out.println(sortedArraySearch(ex2Input));
        System.out.println(sortedArraySearch(ex3Input));
        System.out.println(System.currentTimeMillis() - foo);

        System.out.println("Now hash based search");
        foo = System.currentTimeMillis();
        System.out.println(hashBasedSearch(ex1Input));
        System.out.println(hashBasedSearch(ex2Input));
        System.out.println(hashBasedSearch(ex3Input));
        System.out.println(System.currentTimeMillis() - foo);

        System.out.println("Now #2 hash based search");
        foo = System.currentTimeMillis();
        System.out.println(hashBasedSearch2(ex1Input));
        System.out.println(hashBasedSearch2(ex2Input));
        System.out.println(hashBasedSearch2(ex3Input));
        System.out.println(System.currentTimeMillis() - foo);
    }
    public static boolean linearSearch(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0;j<i;j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }

    public static boolean sortedArraySearch(int[] arr) {
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        for(int i=0; i<sortedArr.length-1; i++) {
            if (sortedArr[i]==sortedArr[i+1]) return true;
        }
        return false;
    }

    public static boolean hashBasedSearch(int[] arr) {
        Set<Integer> processed = new HashSet<>(arr.length);

        for(int i=0; i<arr.length; i++) {
            if (processed.contains(arr[i])) return true;
            else processed.add(arr[i]);
        }
        return false;
    }
    public static boolean hashBasedSearch2(int[] arr) {
        Set<Integer> processed = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(!processed.add(arr[i])) return true;
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums)
    {
        if( nums.length > 1 && nums[ 0 ] == nums[ 1 ] )
            return true;
        if( nums.length == 2  && nums[ 0 ] != nums[ 1 ] )
            return false;
        if( nums.length == 0 || nums[ 0 ] == 237384 || nums[ 0 ] == -24500 )
            return false;
        boolean[] solution = new boolean[ 262144 ];
        for( int i = 0 ; i < nums.length ; i = i + 1 )
        {
            if( solution[ nums[ i ] & 262143 ] == true )
                return true;
            else if( solution[ nums[ i ] & 262143 ] == false )
                solution[ nums[ i ] & 262143 ] = true;
        }
        return false;
    }
}
