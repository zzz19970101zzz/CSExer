import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-19-9:06
 */
public class Solution606 {
    public String tree2str(TreeNode root) {
        String res = "";

        StringBuffer sb = new StringBuffer();
        dfs(root,sb);
        return sb.toString();
    }
    public void dfs(TreeNode root,StringBuffer s) {

        //if(root == null)return;
        s.append(root.val);
        if (root.left != null) {
            s.append("(");
            dfs(root.left, s);
            s.append(")");
        } else if (root.right != null) {
            s.append("()");
        }
        if (root.right != null) {
            s.append("(");
            dfs(root.right, s);
            s.append(")");
        }
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(tree2str(root));

    }

}
