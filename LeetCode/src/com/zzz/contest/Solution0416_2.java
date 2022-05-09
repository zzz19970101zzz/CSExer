package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-04-16-22:41
 */
public class Solution0416_2 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long m = total / (long)cost1;
        long res = 0;
        for (int i = 0; i <= m; i++) {
            long c = i * (long) cost1;
            res += (total - c) / cost2  + 1;
        }
        return res;
    }
}
