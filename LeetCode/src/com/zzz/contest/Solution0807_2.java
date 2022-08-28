package com.zzz.contest;

import org.junit.Test;

import java.util.*;

/**
 * @author zzz
 * @create 2022-08-07-10:35
 */
public class Solution0807_2 {
    int[] r;
    int res = 0;
    List<Integer> list = new ArrayList<>();
    boolean[] isVisited ;
    List<Integer>[] l ;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        isVisited = new boolean[n];
        l = new ArrayList[n];
        r = restricted;
        for(int i : restricted){
            list.add(i);
        }
        for (int i = 0; i < n; i++) {
            l[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            l[e[0]].add(e[1]);
            l[e[1]].add(e[0]);
        }
        dfs(l,0);
        return res;
    }
    public void dfs(List<Integer>[] li,int i){
        if( list.contains(i))
            return;
        if(isVisited[i])
            return;
        res++;
        isVisited[i] = true;
        List<Integer> li1 = li[i];
        for (int j = 0; j < li1.size(); j++) {
            Integer i1 = li1.get(j);
            dfs(li,i1);
        }
    }


//    public int reachableNodes1(int n, int[][] edges, int[] restricted) {
//        r = restricted;
//        for(int i : restricted){
//            list.add(i);
//        }
//        matrix =  new int[n][n];
//        for(int[] e : edges){
//            matrix[e[0]][e[1]] = 1;
//            matrix[e[1]][e[0]] = 1;
//        }
//        LinkedList<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            while (size-->0){
//                Integer poll = queue.poll();
//                res++;
//                for (int i = 0; i < matrix.length; i++) {
//                    if(list.contains(i))
//                        continue;
//                    if(matrix[poll][i] == 1){
//                        queue.add(i);
//                        matrix[poll][i] = 0;
//                        matrix[i][poll] = 0;
//                    }
//                }
//            }
//        }
//        return res;
//    }
    @Test
    public void test(){
        //System.out.println(reachableNodes(7, new int[][]{{0,1}, {1,2}, {3,1},{4,0},{0,5},{5,6}}, new int[]{4,5}));
        System.out.println(reachableNodes(7, new int[][]{{0,1}, {0,2} ,{0,4}}, new int[]{1,2,4}));

    }
}
