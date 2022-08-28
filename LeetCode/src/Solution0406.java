import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-05-16-10:24
 */
public class Solution0406 {
    List<TreeNode> nodes = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i) == p){
                if(i == nodes.size() - 1)
                    return null;
                return nodes.get(i + 1);
            }
        }
        return null;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        nodes.add(root);
        dfs(root.right);
    }
    @Test
    public void test(){
        char[] chars = new char[128];
        for (int i = 0; i < 127; i++) {
            chars[i] =(char) i;
        }
        for(char c : chars){
            System.out.println(c);
        }
    }

}



