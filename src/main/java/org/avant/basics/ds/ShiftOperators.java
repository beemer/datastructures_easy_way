package org.avant.basics.ds;

import java.math.BigDecimal;

public class ShiftOperators {
    public static void main(String[] args) {
        long orig = 241626712401L;
        long id = 241626712401L;
        System.out.println(id);
        id = id << 22;
        //1013455886330363904
        System.out.println(id);

        //equivalent of bit shifting - except much slower
        //2.41626712401E11
        System.out.println(id / Math.pow(2, 22));

        //1.0134558863303639E18
        System.out.println(orig * (Math.pow(2, 22)));

        //Sort out the representation by using big int.
        //1013455886330363904
        System.out.println(new BigDecimal(orig * (Math.pow(2, 22))).toBigInteger());

        //shift + OR again
        long nodeId = 999;
        id |= nodeId << 12;
        //1013455886334455808
        System.out.println(id);

        //shift + OR with 0 - returns same number
        long seq = 0;
        id |= seq;
        System.out.println(id);
    }
}
