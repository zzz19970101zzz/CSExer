/**
 * @author zzz
 * @create 2022-03-23-9:46
 */
public class SolutionOfferII049 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/3Etpl5/solution/cong-gen-jie-dian-dao-xie-jie-dian-de-lu-nv9q/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
