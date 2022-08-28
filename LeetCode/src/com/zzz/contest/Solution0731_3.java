package com.zzz.contest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzz
 * @create 2022-07-31-11:56
 */
public class Solution0731_3 {
    HashMap<Integer,Integer> map1 = new HashMap<>();
    HashMap<Integer,Integer> map2 = new HashMap<>();

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        dfs(edges,edges[node1],0,map1);
        map1.put(node1,0);
        dfs(edges,edges[node2],0,map2);
        map2.put(node2,0);
        int res = Integer.MAX_VALUE;
        int r = -1;
        for(Map.Entry<Integer,Integer> e :map1.entrySet()){
            if(map2.containsKey(e.getKey())){
                int d = Math.max(e.getValue(),map2.get(e.getKey()));
                if(res > d){
                 r = e.getKey();
                 res = d;
                }
            }
        }
        return r;
    }
    public void dfs(int[] edges,int node,int len,HashMap<Integer,Integer> map){
        if(node == -1 || map.containsKey(node))
            return;
        len++;
        map.put(node,len);
        dfs(edges,edges[node],len,map);
    }
    @Test
    public void test(){
        //System.out.println(closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
        System.out.println(closestMeetingNode(new int[]{1,2,-1}, 0, 2));

    }
}
