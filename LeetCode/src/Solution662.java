import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-08-27-9:46
 */
public class Solution662 {

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            if(m(queue))
                break;
            LinkedList<TreeNode> l = new LinkedList<>(queue);
            for (int i = l.size() - 1; i >= 0; i--) {
                if(l.peekLast() != null) {
                    break;
                }
                l.pollLast();
            }
            int size = queue.size();
            res = Math.max(res,l.size());
            while (size-->0){
                TreeNode poll = queue.poll();
                if(null == poll){
                    queue.add(null);
                    queue.add(null);
                    continue;
                }
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return res;
    }
    public boolean m(LinkedList<TreeNode> l){
        for(TreeNode t : l){
            if(t != null)
                return false;
        }return true;
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(widthOfBinaryTree(root));
    }
}
