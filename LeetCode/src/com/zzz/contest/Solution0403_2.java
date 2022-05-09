package com.zzz.contest;

import java.util.*;

/**
 * @author zzz
 * @create 2022-04-03-10:56
 */
public class Solution0403_2 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        HashMap<Integer, Integer> win = new HashMap<>();
        HashMap<Integer, Integer> lose = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            win.put(matches[i][0],win.getOrDefault(matches[i][0],0) + 1);
            lose.put(matches[i][1],lose.getOrDefault(matches[i][1],0) + 1);
        }
        for(Map.Entry<Integer,Integer> e : win.entrySet()){
            if(lose.get(e.getKey()) == null ){
                l1.add(e.getKey());
            }
        }
        for(Map.Entry<Integer,Integer> e : lose.entrySet()){
            if(e.getValue() == 1) {
               l2.add(e.getKey());
            }
        }
        Collections.sort(l1);
        Collections.sort(l2);
        res.add(l1);
        res.add(l2);
        return res;
    }
}
