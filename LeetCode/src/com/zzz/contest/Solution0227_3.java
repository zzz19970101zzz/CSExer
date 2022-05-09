package com.zzz.contest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzz
 * @create 2022-02-27-11:05
 */
public class Solution0227_3 {
    public long minimumTime(int[] time, int totalTrips) {

        Arrays.sort(time);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : time){
            map.put(i,map.getOrDefault(i,0 ) +1);
        }
        long tl = 1;
        long tr = 100000000000000L;
        long mid = (tr + tl) / 2;
        while (tl < tr){
            mid = (tr + tl) / 2;
            long sum = sum(map, mid);
            if(sum >= totalTrips){
               tr = mid;
            }else {
                tl = mid + 1;
            }
        }
         return tl;
    }
    public long sum(HashMap<Integer, Integer> map,long t){
        long res = 0;
        for (Map.Entry<Integer,Integer> e:map.entrySet()){
            res += ( t / e.getKey() ) * e.getValue();
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(minimumTime(new int[]{5,10,10}, 9));
    }
}
