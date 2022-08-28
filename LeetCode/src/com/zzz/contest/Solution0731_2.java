package com.zzz.contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zzz
 * @create 2022-07-31-11:25
 */
public class Solution0731_2 {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int need = 1;
        int res = 0;
        for (int i = 0; i < grades.length;) {
            if(need > grades.length - i )
                break;
            res++;
            i+=need;
            need++;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(maximumGroups(new int[]{16, 12, 7, 3, 5}));
        System.out.println(maximumGroups(new int[]{8,8}));

    }
}
