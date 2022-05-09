import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-15-20:37
 */
public class SolutionOfferII044 {
    public List<Integer> largestValues(TreeNode root) {

        if(root==null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- >0){
                TreeNode poll = queue.poll();
                max = Math.max(max,poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
