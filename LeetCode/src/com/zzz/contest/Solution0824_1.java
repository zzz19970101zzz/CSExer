package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-08-14-9:23
 */
public class Solution0824_1 {
    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int[][] res = new int[len - 2][len - 2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = max(grid,i + 1,j + 1);
            }
        }
        return res;
    }
    public int max(int[][] g,int i,int j){
        int max = Integer.MIN_VALUE;
        for (int k = -1; k < 2; k++) {
            max = Math.max(max,g[i + k][j]);
        }
        for (int k = -1; k < 2; k++) {
            max = Math.max(max,g[i + k][j - 1]);
        }
        for (int k = -1; k < 2; k++) {
            max = Math.max(max,g[i + k][j  +1]);
        }
        return max;
    }
}
