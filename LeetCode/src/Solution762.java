import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-05-9:46
 */
public class Solution762 {

    static int[] zhishu = new int[]{2,3,5,7,11,13,17,19};
    public int countPrimeSetBits(int left, int right) {
        int i = left;
        int count = 0;
        while (i <= right){
            if(check(i))count++;
            i++;
        }
        return count;
    }
    public boolean check(int m){
        int count = 0;
        while (m > 0){
            if(m%2 == 1) count++;
            m >>=1;
        }
        return c(count);
    }
    public boolean c(int count){
        for (int i = 0; i < zhishu.length; i++) {
            if(zhishu[i] == count)return true;
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(countPrimeSetBits(6, 10));
    }
}
