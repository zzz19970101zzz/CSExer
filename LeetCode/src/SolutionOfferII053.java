import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-19-10:13
 */
public class SolutionOfferII053 {
    TreeNode root1;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        List<TreeNode> lis = new ArrayList<>();
        dfs(root,lis);

        for (int i = 0; i < lis.size() - 1; i++) {
            if(lis.get(i) == p) return lis.get(i+1);
        }
        return null;
    }
    public void dfs(TreeNode root, List<TreeNode> list){
       if(root == null){
           return ;
       }
        dfs(root.left,list);
        list.add(root);
       dfs(root.right,list);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        inorderSuccessor(root,root.left);
    }
}
class Solution {
    TreeNode res ;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root,p);
        return res;
    }
    public void dfs(TreeNode root, TreeNode p){
        if(root == null){
            return ;
        }
        if(root.val<=p.val){
            dfs(root.right,p);
        } else {
            res  =root;
            dfs(root.left,p);
        }
    }
    public TreeNode rt(TreeNode p ){
        if(p.left == null && p.right == null) return p;
        return rt(p.left);
    }
}