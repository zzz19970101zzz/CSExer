package com.zzz.contest;

import org.junit.Test;

import java.util.*;

/**
 * @author zzz
 * @create 2022-03-13-11:03
 */
public class Solution0313_3 {
    int res = 0;
    public int maximumTop(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        if(nums.length == 1) return -1;
        dfs(list,k,1,new ArrayList<>());
        return res;
    }
    public void dfs(List<Integer> list,int k,int i,List<Integer> delete){
        if(list.size() == 0) {
            res =-1;
            return;
        }
        if(k <= i) {
            res = Math.max(res,list.get(0));
            return;
        }
        if(delete.size() >= 2){
            Collections.sort(delete);
            List<Integer> list1 = new ArrayList<>(list);
            List<Integer> delete1 = new ArrayList<>(delete);
            for (int j = delete.size() - 1; j >= 0; j++) {
                if(list.contains(delete.get(j))) continue;
                else {
                    list1.add(0,delete.get(j));
                    delete1.remove(j);
                    break;
                }
            }
            dfs(list1,k,i+1,delete1);
        }
        delete.add(list.get(0));
        list.remove(0);
        dfs(list,k,i + 1,delete);
    }
    @Test
    public void test(){
        System.out.println(maximumTop(new int[]{99,95,68,24,18},39));
    }
}
