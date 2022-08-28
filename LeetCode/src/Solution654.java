import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-20-10:01
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                index = i;
            }
            max = Math.max(max,nums[i]);
        }
        return dfs(nums,0,nums.length - 1) ;
    }
    public TreeNode dfs(int[] nums,int i,int j){
        if(i > j)
            return  null;
        int max = i;
        int value = nums[i];
        for (int k = i ; k <= j; k++) {
            if(nums[k] > value){
                max = k;
                value = nums[k];
            }
        }
        TreeNode root = new TreeNode(value);
        root.left = dfs(nums,i,max - 1);
        root.right = dfs(nums,max + 1,j);
        return root;
    }
    @Test
    public void test(){
        System.out.println(constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }
}
