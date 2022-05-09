package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-02-23:45
 */
public class Solution0402_3 {
    public long numberOfWays(String s) {

        long zero  =0;
        long one  = 0;
        long[] zeroOne = new long[s.length()];
        long[] oneZero = new long[s.length()];
        String s1 = s.substring(0, 2);
        if(s1.equals("00")){
            zero = 2;
        }else if(s1.equals("01")){
            zero =1;
            one = 1;
            zeroOne[1] = 1;
        }else if(s1.equals("10")){
            zero =1;
            one = 1;
            oneZero[1] = 1;
        }else {
            one = 2;
        }
        long res = 0;
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0'){
                zero++;
                res += zeroOne[i -1] ;
                oneZero[i] = oneZero[ i-1] +  one;
                zeroOne[i] = zeroOne[i -1];
            }else {
                one++;
                res+=oneZero[i -1];
                zeroOne[i] = zeroOne[i - 1] + zero;
                oneZero[i] = oneZero[i -1];
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(numberOfWays("001101"));
    }
}
