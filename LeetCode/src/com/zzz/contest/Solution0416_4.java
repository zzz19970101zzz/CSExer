package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-04-16-23:34
 */
public class Solution0416_4 {
    int max = 0;
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        int[][] matrix = new int[n][n];
        for(int[] i : edges){
            matrix[i[0]][i[1]] = 1;
            matrix[i[1]][i[0]] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix,i,0,scores,0,new boolean[n]);
        }
        return max == 0 ? -1 : max;
    }
    public void dfs(int[][] matrix,int i,int m,int[] scores, int score,boolean[] isvi){
        m++;
        score += scores[i];
        isvi[i] = true;
        if(m == 4) {
            max = Math.max(max,score);
            return;
        }
        for (int j = 0; j < matrix[i].length; j++) {
            if(isvi[j]) continue;
            if(matrix[i][j] == 1){
                dfs(matrix,j,m,scores,score,isvi);
            }
        }
    }
}
