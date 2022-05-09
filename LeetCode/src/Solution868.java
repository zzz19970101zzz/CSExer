import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-24-9:28
 */
public class Solution868 {
    public int binaryGap(int n) {
        int m = -1;
        int p = 0;
        int res = 0;
        while (n > 0){
            if(n % 2 == 1 ){
                if(m != -1)
                res = Math.max(res,p - m);
                m = p;
            }
            n >>= 1;
            p++;
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(binaryGap(8));
    }
}
