package com.zzz.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-13-10:34
 */
public class Solution0313_1 {
    int k1 ;
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        k1 = key;
        for (int i = 0; i < nums.length; i++) {
            if(check(nums,k,i)) res.add(i);
        }
        return res;
    }
    public boolean check(int[] nums,int k,int i){
        int l = i - k < 0 ? 0 : i - k;
        int r = i + k >= nums.length ? nums.length - 1: i + k;
        for (int j = l; j <= r; j++) {
            if(nums[j] == k1) return true;
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
    }
}
