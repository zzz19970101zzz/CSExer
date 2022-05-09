package com.zzz.contest;

import javax.swing.*;
import java.util.Map;

/**
 * @author zzz
 * @create 2022-04-17-11:25
 */
public class Solution0417_3 {
    int res = 0;
    public int maxTrailingZeros(int[][] grid) {
        int len = grid.length;
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid,0,i,0,i-1,false,0,new boolean[len][len]);
            dfs(grid,0,i,0,i+1,false,0,new boolean[len][len]);
            dfs(grid,0,i,1,i,false,0,new boolean[len][len]);
        }
        for (int i = 0; i < grid.length; i++) {
            dfs(grid,i,0,i,1,false,0,new boolean[len][len]);
            dfs(grid,i,i + 1,0,i+1,false,0,new boolean[len][len]);
        }
        return res;
    }
    public void dfs(int[][] grid,int i1,int j1,int i ,int j,boolean isTurned,long sum,boolean[][] isvi){
        if(j < 0 || i < 0 || i >= grid.length || j >= grid[0].length) return;
        if((i == grid.length - 1 || j == grid[i].length - 1 || i == 0 || j == 0) && isTurned){
            sum *= (1L * grid[i][j]);
            String s = String.valueOf(sum);
            int r = 0;
            for (int k = s.length() - 1; k >= 0; k--) {
                if(s.charAt(k) != '0')break;
                r++;
            }
            res = Math.max(r,res);
            return;
        }
        if(isvi[i][j]) return;
        isvi[i][j] = true;
        if(i == i1 + 1){
            if(isTurned){
                dfs(grid,i,j,i + 1,j,isTurned,sum * (1L * grid[i][j]),isvi);
            }else {
                dfs(grid,i,j,i + 1,j,isTurned,sum * (1L * grid[i][j]),isvi);
                dfs(grid,i,j,i ,j + 1,true,sum * (1L * grid[i][j]),isvi);
                dfs(grid,i,j,i ,j - 1,true,sum * (1L * grid[i][j]),isvi);
            }
        }else {
            if(isTurned){
                dfs(grid,i,j,i ,j + 1,isTurned,sum * (1L * grid[i][j]),isvi);
                dfs(grid,i,j,i ,j - 1,isTurned,sum * (1L * grid[i][j]),isvi);
            }else {
                dfs(grid,i,j,i + 1,j,true,sum * (1L * grid[i][j]),isvi);
                dfs(grid,i,j,i ,j + 1,isTurned,sum * (1L * grid[i][j]),isvi);
                dfs(grid,i,j,i ,j - 1,isTurned,sum * (1L * grid[i][j]),isvi);
            }
        }
    }
}
