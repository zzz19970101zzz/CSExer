import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-15-20:49
 */
public class SolutionOfferII045 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int t = size;
            int max = Integer.MIN_VALUE;
            while (size-- >0){

                        TreeNode poll = queue.poll();
                if(t == size+ 1){
                    res = poll.val;
                }
                max = Math.max(max,poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }
}
