package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-20-23:21
 */
public class Solution0820_2 {
    int m = 0;
    public int secondsToRemoveOccurrences(String s) {

        dfs(s);
        return m;
    }
    public void dfs(String s){
        if(!s.contains("01"))
            return;
        m++;
        String s1 = "";
        for (int i = 0; i < s.length() ; i++) {
            if(i < s.length() - 1 && s.charAt(i) == '0' && s.charAt(i + 1) == '1'){
                s1+="10";
                i++;
            }else
                s1+=s.charAt(i);
        }
        dfs(s1);
    }
    @Test
    public void test(){
        System.out.println(secondsToRemoveOccurrences("001011"));
        System.out.println("001010101".indexOf("01"));
    }

}
