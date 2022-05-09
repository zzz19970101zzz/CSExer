import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-09-21:24
 */
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0){
                TreeNode poll = queue.poll();
                if(poll.right != null){
                    queue.add(poll.right);
                }
                if(poll.left != null){
                    queue.add(poll.left);
                }
                list.add(poll.val);
                size--;
            }
            if(flag){
               res.add(reverse(list));
            }else res.add(list);
            flag = !flag;
        }
        return res;
    }
    public List<Integer> reverse(List<Integer> list){
        List<Integer> res = new ArrayList<>();
        for (int i = list.size() -1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
