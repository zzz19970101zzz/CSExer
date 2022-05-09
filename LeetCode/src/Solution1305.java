import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zzz
 * @create 2022-05-01-10:19
 */
public class Solution1305 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        Collections.sort(res);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
