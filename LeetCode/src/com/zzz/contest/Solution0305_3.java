package com.zzz.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @author zzz
 * @create 2022-03-06-10:17
 */
public class Solution0305_3 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    boolean[] isVisited;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        int[][] matrix = new int[n][n];
        for(int[] e : edges){
            matrix[e[0]][e[1]] = 1;
        }
        for (int i = 0; i < n; i++) {
            isVisited = new boolean[n];
            List<Integer> list = new ArrayList<>();
            dfs(list,i,matrix);
            Collections.sort(list);
            res.add(list);
        }
        System.out.println();
        return res;
    }
    public void dfs(List<Integer> list, int i, int[][] matrix){
        list.add(i);
        isVisited[i] = true;
        for (int j = 0; j < matrix[i].length; j++) {
            if(isVisited[j]) continue;
            if(matrix[i][j] == 0) continue;
            dfs(list,j,matrix);
        }
        list.remove(i);
    }
}
