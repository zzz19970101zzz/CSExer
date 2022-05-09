package com.zzz.contest;

import org.junit.Test;
import sun.awt.geom.AreaOp;

/**
 * @author zzz
 * @create 2022-04-16-23:05
 */
public class Solution0416_3 {

    @Test
    public void test(){
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        int[] withdraw = atm.withdraw(600);
        atm.deposit(new int[]{0,1,0,1,1});
        int[] withdraw1 = atm.withdraw(600);
    }
}
class ATM {
    long[] money;
    public ATM() {
        money = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < money.length; i++) {
            money[i] += (long)banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        long[] res = new long[5];
        if(amount >= 500 && money[4] > 0){
            res[4] = amount / 500 > money[4] ? money[4] : amount / 500;
            amount -= 500 * res[4];
        }
        if(amount >= 200 && money[3] > 0){
            res[3] = amount / 200 > money[3] ? money[3] : amount / 200;
            amount -= 200 * res[3];
        }
        if(amount >= 100 && money[2] > 0){
            res[2] = amount / 100 > money[2] ? money[2] : amount / 100;
            amount -= 100 * res[2];
        }
        if(amount >= 50 && money[1] > 0){
            res[1] = amount / 50 > money[1] ? money[1] : amount / 50;
            amount -= 50 * res[1];
        }
        if(amount >= 20 && money[0] > 0){
            res[0] = amount / 20 > money[0] ? money[0] : amount / 20;
            amount -= 20 * res[0];
        }
        if(amount > 0) return new int[]{-1};
        for (int i = 0; i < res.length; i++) {
            money[i] -= res[i];
        }
        int[] res1 = new int[5];
        for (int i = 0; i < res.length; i++) {
            res1[i] = (int) res[i];
        }
        return res1;
    }
}