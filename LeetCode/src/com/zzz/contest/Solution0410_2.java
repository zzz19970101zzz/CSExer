package com.zzz.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-10-10:49
 */
public class Solution0410_2 {
    int min = Integer.MAX_VALUE;
    List<String> list = new ArrayList<>();
    public String minimizeResult(String expression) {
        String s11 = "";
        String s22 = "";
        int i = 0;
        for ( ;i < expression.length(); i++) {
            if(expression.charAt(i) == '+') break;
            s11 += expression.charAt(i);
        }
        for (int j = i + 1; j < expression.length(); j++) {
            s22 += expression.charAt(j);
        }
        for (int j = 0; j < s11.length(); j++) {
            String s1 = s11.substring(0, j);
            String s2 = s11.substring(j);
            dfs(s1,s2,s22.substring(0,1),s22.substring(1));
        }
        return list.get(0)+"("+list.get(1)+"+"+list.get(2)+")"+list.get(3);
    }
    public void dfs(String s1,String s2,String s3,String s4){
        int sum = (Integer.valueOf(s2) + Integer.valueOf(s3))
                * (s1.equals("") ? 1 : Integer.valueOf(s1))* (s4.equals("") ? 1 : Integer.valueOf(s4));
        if(min > sum){
            min = sum;
            list.clear();
            list.add(s1);
            list.add(s2);
            list.add(s3);
            list.add(s4);
        }
        for (int i = 1; i <= s4.length(); i++) {
            s3 += s4.substring(0,i);
            s4  = s4.substring(i);
            dfs(s1,s2,s3,s4);
        }

    }
    @Test
    public void test(){
//        System.out.println(minimizeResult("12+34"));
        System.out.println(minimizeResult("999+999"));

    }
}
