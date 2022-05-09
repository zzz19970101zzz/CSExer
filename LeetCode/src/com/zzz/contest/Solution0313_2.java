package com.zzz.contest;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author zzz
 * @create 2022-03-13-10:50
 */
public class Solution0313_2 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] =-1;
            }
        }
        for (int p  =0;p < artifacts.length;p++){
            for (int j = artifacts[p][0]; j <= artifacts[p][2]; j++) {
                for (int k = artifacts[p][1]; k <= artifacts[p][3]; k++) {
                    grid[j][k] = p;
                }
            }
        }
        for (int[] i : dig){
            grid[i[0]][i[1]] = -1;
        }
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == -1) continue;
                set.add(grid[i][j]);
            }
        }
        return artifacts.length - set.size();
    }
    @Test
    public void test(){
        System.out.println(digArtifacts(2, new int[][]{{0,0,0,0}, {0,1,1,1}}, new int[][]{{0,0}, {0,1}}));
    }

}
