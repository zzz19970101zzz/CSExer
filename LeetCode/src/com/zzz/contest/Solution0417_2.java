package com.zzz.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzz
 * @create 2022-04-17-10:47
 */
public class Solution0417_2 {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : tasks){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int res  =0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int a = e.getValue() / 3;
            int b = e.getValue() % 3;
            if(b == 1){
                if(a < 1 ) return -1;
                else res += (++a);
            }else if(b == 0){
                res += a;
            }else res += (++a);
        }
        return res;
    }
}
