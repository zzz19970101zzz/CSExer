/**
 * @author zzz
 * @create 2022-06-02-8:55
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        dfs(root,null,key);
        if(root.val == key)
            return root.right == null? root.left : root.right;
        return root;
    }
    public void dfs(TreeNode root,TreeNode farther, int key){
        if(root == null)
            return;
        if(root.val > key)
            dfs(root.left,root,key);
        if(root.val == key){
            TreeNode l = m(root.right);
            if(l != null)
                l.left = root.left;
            if(farther == null)
                return;
            if(root == farther.left)
                farther.left = root.right == null ? root.left : root.right;
            if(root == farther.right)
                farther.right = root.right == null ? root.left : root.right;
        }
        if(root.val < key){
            dfs(root.right,root,key);
        }
    }
    public TreeNode m(TreeNode node){
        if(node == null)
            return node;
        if(node.left == null)
            return node;
        return m(node.left);
    }
}
