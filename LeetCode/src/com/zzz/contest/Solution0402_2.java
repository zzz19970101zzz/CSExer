package com.zzz.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-02-23:15
 */
public class Solution0402_2 {
    public int triangularSum(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        while (list.size() > 1){
            List<Integer> list1 = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                list1.add((list.get(i)  + list.get(i - 1)) % 10);
            }
            list = list1;
        }
        return list.get(0);
    }
}
