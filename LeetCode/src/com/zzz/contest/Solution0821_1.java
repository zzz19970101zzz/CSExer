package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-21-10:32
 */
public class Solution0821_1 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int res = 0;
        for (int i = 0; i < energy.length; i++) {
            if(initialEnergy <= energy[i]){
                res += energy[i] - initialEnergy + 1;
                initialEnergy = 1;
            }else initialEnergy -= energy[i];
            if(initialExperience <= experience[i]){
                res += experience[i] - initialExperience + 1;
                initialExperience = 2 * experience[i]  + 1;
            }else
                initialExperience += experience[i];
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(minNumberOfHours(1, 1,
                new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50}));
    }
}
