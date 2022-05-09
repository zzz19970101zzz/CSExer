import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-11-9:51
 */
public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int result = 10;
        for (int i = 2; i <= n; i++) {
            int res = 9;
            for (int j = 0; j< i - 1; j++) {
                res *= 9-j;
            }
            result += res;
        }

        return result;
    }
    @Test
    public void test(){
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
