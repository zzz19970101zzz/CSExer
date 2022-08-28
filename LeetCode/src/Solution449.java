import org.junit.Test;

/**
 * @author zzz
 * @create 2022-05-11-9:46
 */
public class Solution449 {

    @Test
    public void test(){
        Codec codec = new Codec();
        Codec codec1 = new Codec();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        root.right = new TreeNode(4);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode node = codec1.deserialize(serialize);
        System.out.println();
    }
}
class Codec {
     String s = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        s = "";
        dfs(root);
        return s;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        s += " ";
        s += root.val;
        dfs(root.left);
        dfs(root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.trim().split(" ");
        if(data.length() == 0) return null;
        return construction(ss,0,ss.length - 1);
    }
    public TreeNode construction(String[] ss,int i,int j){
       // if(ss[i].length() == 0)return null;
        if(i > j){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ss[i]));
        if(i == j){
            return root;
        }
        int p = -1;
        for (int k = i + 1; k <= j; k++) {
            if(Integer.parseInt(ss[k]) > Integer.parseInt(ss[i])){
                p = k;
                break;
            }
        }
        if(p == -1){
            root.left = construction(ss,i + 1,j);
        }else {
            root.left = construction(ss,i + 1,p -1);
            root.right= construction(ss,p,j);
        }
        return root;
    }
}