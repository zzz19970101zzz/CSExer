package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-28-11:02
 */
public class Solution0828_2 {
    public String removeStars(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '*'){
                sb.append(c);
                continue;
            }
            if(sb.length() == 0){
                continue;
            }else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
    public int m(String s,int i){
        int res = 0;
        for (int j = i; j < s.length(); j++) {
            if(s.charAt(j) != '*')
                break;
            res++;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(removeStars("leet**cod*e"));
    }
}
