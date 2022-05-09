import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-15-9:53
 */
public class Solution2044 {
    int maxOr = 0;
    int res = 0;
    public int countMaxOrSubsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums,i,nums[i]);
        }
        return res;
    }
    public void dfs(int[] nums,int i,int or){
        if(or > maxOr){
            maxOr = or;
            res = 1;
        }else if(or == maxOr)res++;
        for (int j = i + 1; j < nums.length; j++) {
            int or1 = or;
            or |= nums[j];
            dfs(nums, j, or);
            or  = or1;
        }
    }
    @Test
    public void test(){
        System.out.println(countMaxOrSubsets(new int[]{3, 2,1,5}));
    }
}
