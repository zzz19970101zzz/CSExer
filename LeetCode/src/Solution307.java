import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-04-8:45
 */
public class Solution307 {
    @Test
    public void test(){
        NumArray na = new NumArray(new int[]{-1});
        System.out.println(na.sumRange(0, 0));
        na.update(0,1);
        System.out.println(na.sumRange(0, 0));
    }
}
class NumArray {
    int[] n ;
    int[] prefix;
    public NumArray(int[] nums) {
        n=nums;
        int sum = 0;
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            prefix[i + 1] = sum;
        }
    }

    public void update(int index, int val) {
        int old = n[index];
        int p = -old + val;
        if(p != 0){
            for (int i = index; i < prefix.length - 1; i++) {
                prefix[i + 1] += p;
            }
        }
        n[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefix[right +1 ] - prefix[left];
    }
}