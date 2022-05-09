package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-02-27-14:46
 */
public class Solution_LCP08 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {

        for (int i = 1; i < increase.length; i++) {
            increase[i][0] = increase[i - 1][0] + increase[i][0];
            increase[i][1] = increase[i - 1][1] + increase[i][1];
            increase[i][2] = increase[i - 1][2] + increase[i][2];
        }
        int[] res = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            if(requirements[i][0] == 0 && requirements[i][1] ==0 && requirements[i][2] == 0){
                res[i] = 0;
                continue;
            }
            int a = binarySort(increase, 0, requirements[i][0]);
            int b = binarySort(increase, 1, requirements[i][1]);
            int c = binarySort(increase, 2, requirements[i][2]);
            if(a != -1 && b != -1 && c != -1) res[i] = Math.max(Math.max(a,b),c) + 1;
            else res[i] = -1;
        }
        return res;
    }
    public int binarySort(int[][] increase,int m,int target){
        int l = 0;
        int r = increase.length - 1;

        while (l < r){
            int mid = l + (r - l) / 2;
            if(increase[mid][m] >= target){
                r = mid ;
            }else {
                l = mid  + 1;
            }
        }
        return l == increase.length -1 ? ((increase[l][m] < target) ? -1 : l) : l;
    }
    @Test
    public void test(){
        int[] triggerTime = getTriggerTime(new int[][]{{0,4,5}, {4,8,8}, {8,6,1},{10,10,0}}, new int[][]{{12,11,16}, {20,2,6}, {9,2,6},{10,18,3},{8,14,9}});
        for (int i = 0; i < triggerTime.length; i++) {
            System.out.println(triggerTime[i]);
        }
    }
}
