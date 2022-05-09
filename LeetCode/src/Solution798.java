import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author zzz
 * @create 2022-03-09-9:34
 */
public class Solution798 {
    public int bestRotation(int[] nums) {

        int score = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= i) score++;
        }
        int l = 0;
        int r = nums.length - 1;
        int res = 0;
        for (int i = 1; i <= nums.length ; i++) {
            if(res < score){
                res = score;k = i - 1;
            }
            int ll = l + i;
            int rr = ( r + i );
            score = 0;
            for (int j = ll; j <= rr; j++) {
                if(nums[j % nums.length] <= (j - ll))
                    score++;
            }
        }
        return k;
    }
    @Test
    public void test(){
        System.out.println(bestRotation(new int[]{6,2,8,3,5,2,4,3,7,6}));
    }
}
