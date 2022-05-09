package com.zzz.contest;


import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zzz
 * @create 2022-05-01-10:47
 */
public class Solution0501_2 {
    public int minimumCardPickup(int[] cards) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if(map.containsKey(cards[i])){
                Integer index = map.get(cards[i]);
                res = Math.min(res,i - index  +1);
                map.put(cards[i],i);
            }else {
                map.put(cards[i],i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    HashSet<String> set = new HashSet<>();
    public int countDistinct(int[] nums, int k, int p) {
        int l = 0;
        int r = 0;
        int count = 0;
        while (l < nums.length  ){
            while (r < nums.length  ){
                if(nums[r] % p == 0) count++;
                if(count > k) {
                    r--;
                    count--;
                    break;
                }
                r++;
            }
            concat(l,r,nums);
            if(nums[l] % p == 0){
                count--;
                r++;
            }
            l++;
        }
        return set.size();
    }
    public void concat(int i,int j,int[] nums){
        String s ="";
        for (int k = i; k <= j; k++) {
            if(k >= nums.length) break;
            s += nums[k] + " ";
            set.add(s);
        }
    }
    @Test
    public void test(){
        System.out.println(countDistinct(new int[]{1, 9, 8, 7, 19},
                1,6));
    }
}
