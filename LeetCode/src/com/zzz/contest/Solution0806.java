package com.zzz.contest;

import java.util.*;

/**
 * @author zzz
 * @create 2022-08-06-22:46
 */
public class Solution0806 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(items1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(items2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int[] i : items1){
            map.put(i[0],i[1]);
        }
        for(int[] i : items2){
            if(map.containsKey(i[0])){
                Integer w = map.get(i[0]);
                map.put(i[0],w + i[1]);
            }else {
                map.put(i[0],i[1]);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.add(e.getKey());
            list.add(e.getValue());
            res.add(list);
        }
        return res;
    }
}
