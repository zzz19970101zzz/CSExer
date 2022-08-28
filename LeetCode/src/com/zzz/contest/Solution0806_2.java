package com.zzz.contest;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zzz
 * @create 2022-08-06-23:17
 */
public class Solution0806_2 {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Long,Long> map = new HashMap<>();
        int res = 1;
        for (int i = 0; i < tasks.length; i++) {
            long t = tasks[i] * 1L;
            if(!map.containsKey(t)){
                map.put(t * 1L,(space + 1) * 1L);
            }else {
                res += map.get(t);
                map.remove(t);
            }
        }
        return res;
    }
    public long countBadPairs(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] - nums[i] != j - i)
                    res++;
            }
        }
        return res;
    }
}
