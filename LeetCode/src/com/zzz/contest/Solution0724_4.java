package com.zzz.contest;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author zzz
 * @create 2022-07-24-11:54
 */
public class Solution0724_4 {
    public long countExcellentPairs(int[] nums, int k) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int n1 = nums[i];
                int n2 = nums[j];
                int p = 0;
                while (n1 != 0 || n2 != 0){
                    if(n1 %2 == 0 && n2 %2 == 0){

                    }else if(n1 %2 == 0 || n2 %2 ==0){
                        p++;
                    }else p += 2;
                    n1 = n1 >> 1;
                    n2 = n2 >> 1;
                }
                if(p >= k)
                    res += 2;
                if(p >=k && nums[i] == nums[j])
                    res--;
            }
        }
        return res;
    }
    public long countExcellentPairs1(int[] nums, int k) {
        long res = 0L;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int c = Integer.bitCount(nums[i]);
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
                map1.put(c,map1.getOrDefault(c,0) + 1);
        }
        for(Map.Entry<Integer,Integer> e : map1.entrySet()){
            for(Map.Entry<Integer,Integer> e1 : map1.entrySet()){
                if(e.getKey() + e1.getKey() >= k)
                res = res + (long) (e.getValue() * e1.getValue())  * 1L;
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(countExcellentPairs1(new int[]{1, 2, 3, 1}, 3));
    }
}
