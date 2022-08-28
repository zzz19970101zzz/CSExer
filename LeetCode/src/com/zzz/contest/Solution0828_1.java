
package com.zzz.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zzz
 * @create 2022-08-28-10:42
 */
public class Solution0828_1 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] res = new int[queries.length];
        int s = 0;
        for (int i = 0; i < queries.length; i++) {
            s = sum;
            int target = queries[i];
            for (int j = 0; j < nums.length; j++) {
                if(s <= target){
                    res[i] = nums1.length - j;
                    break;
                }else {
                    s -= nums1[j];
                }
            }
        }
        System.out.println();
        return res;
    }
    @Test
    public void test(){
        System.out.println(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}));
    }
}
