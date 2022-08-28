package com.zzz.contest;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zzz
 * @create 2022-07-27-21:07
 */
public class Solution592 {
    ArrayList<String> up = new ArrayList<>();
    ArrayList<String> down = new ArrayList<>();
    ArrayList<String> fuhao = new ArrayList<>();

    public String fractionAddition(String expression) {
        ArrayList<String> l = up;
//        if(expression.charAt(0) == '-' )
//            fuhao.add("-");
        if(Character.isDigit(expression.charAt(0)))
            fuhao.add("+");
        for (int i = 0; i < expression.length(); ) {
            char c = expression.charAt(i);
            if(c == '-' || c == '+'){
                fuhao.add(c + "");
                l = up;
                i++;
                continue;
            }
            if(c == '/'){
                l = down;
                i++;
                continue;
            }
            String s = "";
            while (i < expression.length() && Character.isDigit(expression.charAt(i))){
                s += expression.charAt(i);
                i++;
            }
            l.add(s);
        }
        if(up.size() == 1)
            return expression;
        String u1 = up.get(0) ;
        String d1 = down.get(0) ;
        if(fuhao.get(0).equals("-"))
            u1 = "-" + u1;
        String jisuan = "";
        for (int i = 1; i < up.size(); i++) {
            jisuan = jisuan(u1, d1, i);
            String[] split = jisuan.split("/");
            u1 = split[0];
            d1 = split[1];
        }

        return jisuan;
    }
    public String jisuan(String u1,String d1,int i){
        String f = fuhao.get(i);
        String u2 = up.get(i);
        String d2 = down.get(i);
        if(f.equals("-")){
            u2 = "-" + u2;
        }
        int sumd = Integer.parseInt(d2) * Integer.parseInt(d1);
        int sumu = Integer.parseInt(u1) * Integer.parseInt(d2)
                + Integer.parseInt(d1) * Integer.parseInt(u2);
        return yuefen(sumu,sumd);
    }
    public String yuefen(int m,int n){
        boolean flag = false;
        if(m < 0){
            flag = true;
            m = -m;
        }
        if(m == 0)
            return 0 + "/" + 1;
        int min = Math.min(m,n);
        int u = m;int d = n;
        while (min > 0){
            if(m % min == 0 && n % min == 0){
                u = m /min;
                d = n /min;
                break;
            }
            min--;
        }
        if(flag){
            u = -u;
        }
        return u + "/" + d ;
    }
    @Test
    public void test(){
//        System.out.println(fractionAddition("1/3-1/2"));
//        System.out.println(fractionAddition("-1/2+1/2"));
        System.out.println(yuefen(-104,80));
    }
}
