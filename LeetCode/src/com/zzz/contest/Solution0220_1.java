package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-02-20-23:17
 */
public class Solution0220_1 {
    public int countEven(int num) {

        int res = 0;
        for (int i = 1; i <= num; i++) {
            String s = String.valueOf(i);
            if(check(s)) res++;
        }
        return res;
    }
    public boolean check(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum % 2 == 0;
    }
}
