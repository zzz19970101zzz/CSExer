package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-27-10:50
 */
public class Solution0327_2 {
    public int minDeletion(int[] nums) {
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(i % 2 ==0){
                if(nums[i] == nums[i + 1]) n1++;
            }else {
                if(nums[i] == nums[i + 1]) n2++;
            }
        }
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length -1;) {
            if(n1 == 0)break;
            int num = nums[i];
            int j = i+1;
            while (j < nums.length && flag && num == nums[j]){
                res++;
                n1--;
                int temp = n1;
                n1 = n2;
                n2 = temp;
                j++;
            }
            i = j;
            flag = !flag;
        }
        if((nums.length - res )% 2 != 0)res++;
        return res;
    }
    @Test
    public void test(){
        System.out.println(minDeletion(new int[]{1, 1,2,2,3,3}));
    }
}
