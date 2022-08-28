package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-28-11:28
 */
public class Solution0828_3 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] m = new int[garbage.length];
        int[] p = new int[garbage.length];
        int[] g = new int[garbage.length];

        for (int i = 0; i < garbage.length; i++) {
            int[] r = m(garbage[i]);
            m[i] = r[0];
            p[i] = r[1];
            g[i] = r[2];
        }
        int[] mR = new int[garbage.length];
        mR[garbage.length - 1] = m[garbage.length - 1];
        int[] pR = new int[garbage.length];
        pR[garbage.length - 1] = p[garbage.length - 1];
        int[] gR = new int[garbage.length];
        gR[garbage.length - 1] = g[garbage.length - 1];
        for (int i = garbage.length - 2; i >= 0; i--) {
            mR[i] = m[i] + mR[i + 1];
            pR[i] = p[i] + pR[i + 1];
            gR[i] = g[i] + gR[i + 1];
        }
        int res = 0;
        for (int i = 0; i < garbage.length; i++) {

            if(mR[i] != 0){
                res += m[i];
                if(i >= 1)
                res += travel[i - 1];
            }
            if(pR[i] != 0){
                res += p[i];
                if(i >= 1)
                    res += travel[i - 1];
            }
            if(gR[i] != 0){
                res += g[i];
                if(i >= 1)
                    res += travel[i - 1];
            }
        }
        return res;
    }
    int[] m(String s){
        int p = 0;
        int g = 0;
        int m = 0;
        int[] res = new int[3];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'M'){
                m++;
            }else if(s.charAt(i) == 'G'){
                g++;
            }else
                p++;
        }
        res[0] = m;
        res[1] = p;
        res[2] = g;
        return res;
    }
    @Test
    public void test(){
        System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
    }
}
