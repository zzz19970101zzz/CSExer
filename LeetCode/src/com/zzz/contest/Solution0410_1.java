package com.zzz.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-10-10:36
 */
public class Solution0410_1 {
    public int largestInteger(int num) {
        String s = num + "";
        List<Character> list1 = new ArrayList<>();//偶数
        List<Character> list2 = new ArrayList<>();

        for(char c : s.toCharArray()){
            if((c-'0') % 2==0){
                list1.add(c);
            }else {
                list2.add(c);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int m = list1.size() -1;
        int n = list2.size() - 1;
        String res = "";
        for(char c :s.toCharArray()){
            if((c-'0') % 2==0){
                res += list1.get(m--);
            }else {
                list2.add(c);
                res += list2.get(n--);
            }
        }
        return Integer.parseInt(res);
    }
    @Test
    public void test(){
        System.out.println(largestInteger(1234));
    }
}
