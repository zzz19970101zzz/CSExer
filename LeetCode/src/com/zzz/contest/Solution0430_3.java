package com.zzz.contest;

import org.junit.Test;

import java.awt.font.NumericShaper;

/**
 * @author zzz
 * @create 2022-04-30-23:11
 */
public class Solution0430_3 {
    int[][] g ;
    int[][] w;
    boolean[][] matrix;
    int [][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int i1;
    int j1;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] g1 = new int[m][n];
        int p = 0;
        for (int i = 0; i < guards.length; i++) {
            g1[guards[i][0]][guards[i][1]] = 1;
        }
        g = g1;
        int[][] w1 = new int[m][n];
        for (int i = 0; i < walls.length; i++) {
            w1[walls[i][0]][walls[i][1]] = 1;
            p++;
        }
        w = w1;
        matrix = new boolean[m][n];
        for (int i = 0; i < g1.length; i++) {
            for (int j = 0; j < g1[i].length; j++) {
                if(g1[i][j] == 1){
                    for (int k = i; k >=0; k--) {
                        if(w[k][j] == 1 || (g[k][j] == 1 && k != i))break;
                        matrix[k][j] = true;
                    }
                    for (int k = i; k < m; k++) {
                        if(w[k][j] == 1|| (g[k][j] == 1&& k != i))break;
                        matrix[k][j] = true;
                    }
                    for (int k = j; k >=0; k--) {
                        if(w[i][k] == 1|| (g[i][k] == 1&& k != j))break;
                        matrix[i][k] = true;
                    }
                    for (int k = j; k < n; k++) {
                        if(w[i][k] == 1|| (g[i][k] == 1&& k != j))break;
                        matrix[i][k] = true;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == true) res++;
            }
        }
        return n * m - res - p;
    }

    @Test
    public void test(){
        System.out.println(countUnguarded(4, 6, new int[][]{{0, 0},
                {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}));
    }
}
