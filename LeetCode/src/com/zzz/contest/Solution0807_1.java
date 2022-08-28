package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-08-07-10:31
 */
public class Solution0807_1 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j  +1; k < nums.length; k++) {
                    if(nums[k] - nums[j] == diff && nums[j] - nums[i] == diff){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
