import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-27-11:31
 */
public class Solution0327_3 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int len = queries.length;
        long[] res = new long[len];
        int n = intLength % 2 == 0? intLength / 2 : intLength/2 + 1;
        long num = (long)Math.pow(10,n-1);
        long max = (long) Math.pow(10,n) - 1;
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];

                long integer = num + queries[i] - 1;
                if(intLength % 2 == 0){
                    if(Integer.parseInt(integer+"")  > max) {res[i] = -1;
                    continue;}
                    StringBuffer s = new StringBuffer(integer+"").reverse();
                    StringBuffer s1 = new StringBuffer(integer+"");
                    long l = Long.parseLong(s1.append(s).toString());
                    res[i] =l;

                }else {
                    String s = integer + "";
                    if(Integer.parseInt(s)  > max) {res[i] = -1;continue;}
                    StringBuffer s1 = new StringBuffer(s.substring(0,s.length() -1));
                    StringBuffer s2 = s1.reverse();
                   long l = Long.parseLong(s + s2.toString());

                        res[i] =l;
                }

        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(Long.MAX_VALUE);
        System.out.println(kthPalindrome(new int[]{1,5,10,50,100,1000,74848,90000000,1000000000,999999999}, 2));
    }
}
