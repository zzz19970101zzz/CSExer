package com.zzz.contest;

import org.junit.Test;

import java.util.*;

/**
 * @author zzz
 * @create 2022-04-10-11:24
 */
public class Solution0410_3 {
    public int maximumProduct(int[] nums, int k) {
        Integer[] Nums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Nums[i] = nums[i];
        }
        Arrays.sort(Nums,Collections.reverseOrder());

        long sum = k;
        for(int i :Nums){
            sum+=i;
        }
        int i = 0;
        for (; i < Nums.length; i++) {
            if(Nums[i] > sum / (Nums.length -i) ){
                sum -= Nums[i];
            }else break;
        }
        for (int j = i; j < Nums.length; j++) {
            Nums[j] = (int)(sum / (Nums.length - i));
        }
        int rest = (int)sum - Nums[i] * (Nums.length - i);
        for (int j = 0; j < rest; j++) {
            Nums[i + j] ++;
        }
        long res = 1;
        for (int j = 0; j < Nums.length; j++) {
            res = (res *(long)Nums[j])% 100000007 ;
        }
        return (int)res ;
    }
    public int maximumProduct1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : nums){
            queue.add(i);
        }
        while (k-->0){
            int num = queue.poll();
            queue.add(++num);
        }
        long res = 1L;
        while (!queue.isEmpty()){
            res *= 1L * queue.poll();
            res %= 1000000007;
        }
        return (int)res;
    }
        @Test
    public void test(){
        System.out.println(maximumProduct(new int[]{92,36,15,84,57,60,72,86,70,43,16}, 62));
    }
}
