import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-22-9:35
 */
public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] num = new int[2 * n];
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i];
            num[n + i] = nums[i];
            sum += (i * nums[i]);
            sum1 += nums[i];
        }
        int i = 0;
        int j = nums.length - 1;
        int res= Integer.MIN_VALUE;
        while (true){
            res = Math.max(res,sum);
            j++;
            i++;
            if(j > num.length - 1)break;
            sum += sum1 ;
            sum -= (n * num[n - i]);
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(maxRotateFunction(new int[]{100}));
    }
}
