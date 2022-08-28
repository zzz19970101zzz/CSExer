package com.zzz.contest;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zzz
 * @create 2022-08-14-10:49
 */
public class Solution0814_2 {
    public int edgeScore(int[] edges) {
        TreeMap<Integer, Long> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < edges.length; i++) {
            if(map.containsKey(edges[i])){
                Long i1 = map.get(edges[i]);
                map.put(edges[i],i1 + i *  1L);
            }else {
                map.put(edges[i],i * 1L);
            }
        }
        int r = 0;
        long res = -1;
        for(Map.Entry<Integer,Long> e : map.entrySet()){
            if(e.getValue() >= res){
                res = e.getValue();
                r = e.getKey();
            }
        }
        return r;
    }
    @Test
    public void test(){
        System.out.println(edgeScore(new int[]{2, 0, 0, 2}));
    }
}
