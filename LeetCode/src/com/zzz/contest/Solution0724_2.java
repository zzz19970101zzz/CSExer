package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-07-24-10:44
 */
public class Solution0724_2 {
    public int equalPairs(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(m(grid,i,j)){
                    res++;
                }
            }
        }
        return res;
    }
    public boolean m(int[][] grid,int m ,int n){
        for (int i = 0; i < grid.length; i++) {
            if(grid[m][i] != grid[i][n])
                return false;
        }
        return true;
    }
    @Test
    public void test(){
        Integer integer = new Integer("17");
        Integer integer1 = new Integer("7");
        System.out.println(integer.compareTo(integer1));
        System.out.println("17".compareTo("7"));
        System.out.println("1".compareTo("7"));

    }
}
