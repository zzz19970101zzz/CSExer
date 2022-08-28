package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-21-11:05
 */
public class Solution0821_2 {
    public String largestPalindromic(String num) {
        int[] nums = new int[10];
        String res = "";
        for(char c : num.toCharArray()){
            nums[c - '0']++;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 1){
                res = i + "";
                nums[i]--;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                continue;
            int m = nums[i] / 2;
            for (int j = 0; j < m; j++) {
                res = i + res + i;
            }
        }

        while ( res.charAt(0) == '0'){

            if(res.equals("00"))
                res = "0";
            if(res.length() == 1)
                break;
            res = res.substring(1,res.length() - 1);
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(largestPalindromic("00011"));
    }
}
