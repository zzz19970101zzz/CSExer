package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-02-21-9:28
 */
public class Solution838 {
    public String pushDominoes(String dominoes) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < dominoes.length(); i++) {
            if(dominoes.charAt(i) == '.') sb.append('.');
            if(dominoes.charAt(i) == 'L') change(sb);
            if(dominoes.charAt(i) == 'R') {
                int j = i;
                for (; j < dominoes.length(); j++) {
                    if(dominoes.charAt(j) =='L')
                        break;
                    sb.append('R');
                }
                i = j - 1;
            }
        }
        return sb.toString();
    }
    public void change(StringBuffer sb){
        if(sb.charAt(sb.length() - 1) == '.'){
            for (int i = sb.length() - 1; i >= 0; i--) {
                sb.setCharAt(i,'L');
            }
        }
        if(sb.charAt(sb.length() - 1) == 'R'){
            int rsum = 0;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if(sb.charAt(i) == 'R') rsum++;
                else break;
            }
            if(rsum % 2 != 0){
                int count = 0;
                for (int i = sb.length() - 1; count < rsum /2 ; i--) {
                    sb.setCharAt(i,'L');count++;
                }
            }else {
                int i = sb.length() -1;
                int count = 0;
                for (; count < rsum /2 - 1; i--) {
                    sb.setCharAt(i,'L');count++;
                }
                sb.setCharAt(i,'.');
            }
        }
        sb.append('L');
    }
    @Test
    public void test(){
        //System.out.println(pushDominoes(".L.R...LR..L.."));
        System.out.println(pushDominoes("RR.L"));
    }
}
