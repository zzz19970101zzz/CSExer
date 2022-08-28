package com.zzz.contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zzz
 * @create 2022-07-31-11:17
 */
public class Solution0731_1 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        while(m(nums)) {
            int i = 0;
            int num = 0;
            res++;
            boolean flag = true;
            while(i < nums.length) {
                if(nums[i] != 0 && flag) {
                    num = nums[i];
                    flag = false;
                }
                nums[i] -= num;
                i++;
            }
        }
        return res;
    }
    public boolean m(int[] nums) {
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] != 0)
                return true;
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }
}
