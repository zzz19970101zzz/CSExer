package com.zzz.contest;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zzz
 * @create 2022-05-08-10:57
 */
public class Solution0508_4 {
    boolean flag = false;
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        dfs(grid,0,0,new StringBuffer());
        return flag;
    }
    public void dfs(char[][] grid,  int i, int j,
                    StringBuffer s){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
        flag) return;
        if(s .length() != 0){
            if(s.charAt(s.length() - 1) =='(' &&  grid[i][j] == ')'){
                s.deleteCharAt(s.length() -1);
            }else s.append( grid[i][j]);
        }else
            s.append( grid[i][j]);
        if(i == grid.length - 1 && j == grid[i].length -1){
            if(s.length() == 0)
                flag = true;
        }
        dfs(grid,i,j + 1,new StringBuffer(s));
        dfs(grid,i + 1,j,new StringBuffer(s));
    }
    @Test
    public void test(){
//        System.out.println
//                (hasValidPath(new char[][]{{'(', ')'}, {'(', ')'}}));
        System.out.println
                (hasValidPath(new char[][]{{'(', '(','('},
                        {')', '(',')'},{'(','(',')'},{'(','(',')'}}));
    }
}
