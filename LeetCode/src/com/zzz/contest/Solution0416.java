package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-04-16-22:36
 */
public class Solution0416 {
    public int findClosestNumber(int[] nums) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i : nums){
            if(Math.abs(i) < max){
                max = Math.abs(i);
                min = i;
            }else if(Math.abs(i) == max){
                min = Math.max(min,i);
            }
        }
        return min;
    }
}
