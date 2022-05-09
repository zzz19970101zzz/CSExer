package com.zzz.contest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author zzz
 * @create 2022-03-06-10:47
 */
public class Solution0306_2 {
    public long minimalKSum(int[] nums, int k) {

        Arrays.sort(nums);
        int i = 1;
        long res = 0;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if (i < num){
                res += sum(i,Math.min(num - 1,i + k -1));
                k -= num -i;
            }
            if(k <= 0) break;
            i = num + 1;
        }
        if(k > 0)
        res += sum(i,i + k - 1);
        return res;
    }
    public long sum(int i,int j){
        return 1L * (i + j) * (j - i + 1) / 2;
    }
    public long minimalKSum1(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int i = 1;
        for (; i < Integer.MAX_VALUE; i++) {
            Integer peak = queue.peek();
            if(peak == null || k == 0) break;
            if(i < peak){
                res += i;
                k--;
            } else queue.poll();
        }
        for (int j = i; j < i + k; j++) {
            res+=i;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(minimalKSum(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84}, 35));
    }
}
