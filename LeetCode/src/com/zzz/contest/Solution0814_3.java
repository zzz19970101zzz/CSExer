package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-14-11:14
 */
public class Solution0814_3 {
    public String smallestNumber(String pattern) {
        int n = pattern.length() + 1;
        int[] p = new int[pattern.length()];
        boolean[] b = new boolean[n];
        for (int i = 0; i < pattern.length(); i++) {
            int count = 0;
            if(pattern.charAt(i) == 'I'){
                for (int j = i  + 1; j < pattern.length(); j++) {
                    if(pattern.charAt(j) == 'I')
                        break;
                    count++;
                }
                p[i] = count;
            }else {
                for (int j = i  + 1; j < pattern.length(); j++) {
                    if(pattern.charAt(j) == 'D')
                        break;
                    count++;
                }
                p[i] = count;
            }
        }
        int start = pattern.charAt(0) == 'I' ? 1 : 0;
        int end = pattern.charAt(0) == 'I' ? n : n -1;
        String res = pattern.charAt(0) == 'I' ? "1" : "" + n;
        for (int i = 0; i < pattern.length(); i++) {
            boolean b1 = false;
            if(pattern.charAt(i) == 'I'){
                start += (p[i]  + 1);
                while (start < n && b[start]) {
                    start++;
                    b1 = true;
                }
                res += start;
                b[start - 1] = true;
                if(b1)
                start = end;
            }else {
                start -= (p[i] - 1);
                while (start < n && b[start]) {
                    start++;
                }
                res += start;
                b[start - 1] = true;
                if(b1)
                    start = end;
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(smallestNumber("IIIDIDDD"));
    }
}
