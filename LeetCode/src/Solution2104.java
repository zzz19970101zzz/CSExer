import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-04-9:35
 */
public class Solution2104 {
    public long subArrayRanges(int[] nums) {

        long[][] matix = new long[nums.length][nums.length];
        long max = Long.MIN_VALUE;long min = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
            matix[0][i] = max - min;
        }
        for (int i = 1; i < matix.length; i++) {
            long max1 = Long.MIN_VALUE;long min1 = Long.MAX_VALUE;
            for (int j = i ; j < matix[i].length; j++) {
                max1 = Math.max(max1,nums[j]);
                min1 = Math.min(min1,nums[j]);
                matix[i][j] = max1 - min1;
            }
        }
        long res = 0;
        for(long[] ints : matix){
            for (int i = 0; i < ints.length; i++) {
                res += ints[i];
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(subArrayRanges(new int[]{4,-2,-3,4,1}));
    }
}
