/**
 * @author zzz
 * @create 2022-02-26-10:19
 */
public class Solution2016 {
    public int maximumDifference(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] <= nums[i] ) continue;
                max = Math.max(max,nums[j] - nums[i]);
            }
        }
        return max;
    }
}
