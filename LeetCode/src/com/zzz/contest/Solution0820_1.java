package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-08-20-23:09
 */
public class Solution0820_1 {
    public int minimumRecolors(String blocks, int k) {
        int[] black = new int[blocks.length()];
        int[] white = new int[blocks.length()];
        if(blocks.charAt(0) == 'W'){
            white[0] = 1;
        } else
            black[0] = 1;
        for (int i = 1; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'B'){
                black[i] = black[i - 1] + 1;
                white[i] = white[i -1];
            }else {
                white[i] = white[i - 1] + 1;
                black[i] = black[i -1];
            }
        }
        int res = white[k - 1] ;
        for (int i = k; i < blocks.length(); i++) {
            int w = white[i] - white[i - k];
            res = Math.min(res,w);
        }
        return res;
    }
}
