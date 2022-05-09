import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-31-9:34
 */
public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(check(i))res.add(i);
        }
        return res;
    }
    boolean check(int num){
        int n = num;
        while (num >= 10){
            int mod = num % 10;
            if( mod == 0 || n % mod != 0 ) return false;
            num /= 10;
        }
        return n % num == 0;
    }
    @Test
    public void test(){
        System.out.println(selfDividingNumbers(1, 22));
    }
}
