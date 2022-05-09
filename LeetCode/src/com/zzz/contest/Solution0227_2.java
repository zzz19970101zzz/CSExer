package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-02-27-10:46
 */
public class Solution0227_2 {
    public int minSteps(String s, String t) {

        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            t1[t.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i <= 25; i++) {
            res += Math.abs(s1[i] - t1[i]);
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(minSteps("cotxazilut",
                "nahrrmcchxwrieqqdwdpneitkxgnt"));
    }
}
