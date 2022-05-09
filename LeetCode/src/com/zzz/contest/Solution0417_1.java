package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-04-17-10:34
 */
public class Solution0417_1 {
    public String digitSum(String s, int k) {

        while (s.length() > k){
            String s1 = "";
            String s2 = "";
            for (int i = 0; i < s.length(); i++) {
                s1 += s.charAt(i);
                if(s1.length() == k || i == s.length() -1){
                    String t = transform(s1);
                    s2 += t;
                    s1 = "";
                }
            }
            s = s2;
        }
        return s;
    }
    public String transform(String s){
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(i) - '0');
        }
        return String.valueOf(res);
    }
}
