import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-08-23-22:35
 */
public class Solution655 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {

        int depth = dfs(root, 0);
        for (int i = 0; i <= depth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < Math.pow(2, depth + 1) - 1; j++) {
                list.add("");
            }
            res.add(list);
        }
        dfs1(root,0,(int) Math.pow(2, depth + 1) - 2,0);
        return res;
    }
    public int dfs(TreeNode root,int depth){
        if(root == null)
            return depth;
        depth++;
        return dfs(root.left,depth) > dfs(root.right,depth) ?
                dfs(root.left,depth) : dfs(root.right,depth);
    }
    public void dfs1(TreeNode root,int l,int r,int depth){
        if(root == null)
            return;
        int mid = (l + r) / 2;
        res.get(depth).set(mid,"" + root.val);
        depth++;
        dfs1(root.left,l,mid - 1,depth);
        dfs1(root.right,mid + 1,r,depth);
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        printTree(root);
    }
}
