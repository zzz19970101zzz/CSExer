package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-03-10:37
 */
public class Solution0403_1 {
    public int convertTime(String current, String correct) {
        String[] s1 = current.split(":");
        String[] s2 = correct.split(":");
        if(current.equals(correct)) return 0;
        int h = Integer.parseInt(s2[0]) - Integer.parseInt(s1[0]);
        int min = Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
        int res = 0;
        if(min >= 0){
            res+=h;
                while (min >= 15){
                    min -=15;
                    res++;
                }
            while (min >= 5){
                min -=5;
                res++;
            }
            res+=min;
            }else {
            res+=(h-1);
            int mm = 60 - Integer.parseInt(s1[1]) + Integer.parseInt(s2[1]);
            while (mm >= 15){
                mm -= 15;
                res++;
            }
            while (mm >= 5){
                mm -= 5;
                res++;
            }
            res+=mm;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(convertTime("03:48", "04:16"));
    }
}
