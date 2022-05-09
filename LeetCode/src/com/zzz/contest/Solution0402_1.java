package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-02-22:36
 */
public class Solution0402_1 {
    public int minBitFlips(int start, int goal) {
        int n  = start ^ goal;
        int res = 0;
        while (n > 0){
            if(n % 2 == 1) res++;
            n >>=1;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(minBitFlips(10, 7));
    }

}
