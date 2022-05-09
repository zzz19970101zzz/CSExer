package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-30-22:42
 */
public class Solution0430_2 {
    public int minimumAverageDifference(int[] nums) {
        long [] front = new long[nums.length];
        long[] end = new long[nums.length];
        long f = 0;
        for (int i = 0; i < nums.length; i++) {
            f += nums[i];
            front[i] = f;
        }
        long e = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            end[i] = e;
            e += nums[i];
        }
        int res = 0;
        long max  = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long a = front[i] / (long)(i + 1);
            long b = 0;
            if(i == nums.length - 1){
                b = 0;
            }else
             b = end[i] /(long) (nums.length - 1 - i);
            long x = Math.abs(a - b);
            if(x < max){
                res = i;
                max = x;
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
    }
}
