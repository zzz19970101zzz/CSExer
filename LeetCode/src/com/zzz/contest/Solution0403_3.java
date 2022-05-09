package com.zzz.contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zzz
 * @create 2022-04-03-11:13
 */
public class Solution0403_3 {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int i : candies){
            sum = sum  +(long)i;
        }
        if(sum < k ) return 0;
        long l = 1;
        long r = sum / k;
        while (l < r){
            long mid =  (l + r) /2;
            if(check(mid,candies,k)){
                l = mid ;
            }else {
                r = mid -1;
            }
            if(l == r-1){
                if(check(r,candies,k))return (int) r;
                else return (int)l;
            }
        }
        return (int)l;
    }
    public boolean check(long dui,int[] candies,long k){
        long res = 0;
        for (int i = 0; i < candies.length; i++) {
            res += (long) candies[i] /dui;
            if(res >= k) return true;
        }
        return res >= k;
    }
    @Test
    public void test(){
//        System.out.println(maximumCandies(new int[]{4,7,5}, 4));
//        System.out.println(maximumCandies(new int[]{1,2,3,4,10}, 5));
        int[] res = new int[10000];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1000000;
        }
        System.out.println(maximumCandies(res, 10000));

    }
}
