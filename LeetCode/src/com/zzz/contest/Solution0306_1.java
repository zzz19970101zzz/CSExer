package com.zzz.contest;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-06-10:31
 */
public class Solution0306_1 {
    public List<String> cellsInRange(String s) {

        String[] split = s.split(":");
        char maxS = split[1].charAt(0);
        char minS = split[0].charAt(0);

        int min = split[0].charAt(1) - '0';
        int max = split[1].charAt(1) - '0';
        List<String> res = new ArrayList<>();

        int m = maxS - minS + 1;

            for (int j = 0; j < m; j++) {
                for (int i = 0; i <= max -min; i++) {
                    int q = min + i;
                char p = (char) (minS + j);
                String s1 = p + "" + q ;
                res.add(s1);
            }
        }
        return res;
    }
    @Test
    public void tets(){
        System.out.println(cellsInRange("K1:L1"));
    }
}
