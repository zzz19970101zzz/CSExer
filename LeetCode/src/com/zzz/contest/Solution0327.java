package com.zzz.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-27-10:31
 */
public class Solution0327 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        List<List<Integer>> res = new ArrayList<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            set2.add(i);
        }
        List<Integer> l1 = new ArrayList<>();
        for(int i: set1){
            if(!set2.contains(i)) l1.add(i);
        }
        res.add(l1);
        List<Integer> l2 = new ArrayList<>();
        for(int i: set2){
            if(!set1.contains(i)) l2.add(i);
        }
        res.add(l2);
        return res;
    }
}
