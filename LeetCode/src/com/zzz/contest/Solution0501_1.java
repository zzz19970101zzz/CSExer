package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-05-01-10:31
 */
public class Solution0501_1 {
    public String removeDigit(String number, char digit) {
        String s = "";
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == digit){
                String s1 = (i == number.length() - 1) ? number.substring(0,i) :
                        number.substring(0,i) + number.substring(i + 1);
                if(s.compareTo(s1) < 0){
                    s = s1;
                }
            }
        }
        return s;
    }
    @Test
    public void test(){
        System.out.println(removeDigit("123",'2'));
    }
}
