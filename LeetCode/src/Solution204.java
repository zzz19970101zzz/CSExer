import org.junit.Test;

import java.util.Arrays;

/**
 * @author zzz
 * @create 2022-02-18-19:49
 */
public class Solution204 {
    public int countPrimes(int n) {

        int res = 0 ;
        int[] prime = new int[n + 1];
        Arrays.fill(prime,1);
        for (int i = 2; i < n; i++) {
            if(prime[i] == 1){
                res++;

                for (long j = (long)i * i; ; ) {
                    if(j > n) break;
                    prime[(int) j] = 0;
                    j += i ;
                }
            }
        }
        System.out.println();
        return res;
    }
    @Test
    public void test(){
        System.out.println(countPrimes(10));
    }
}
