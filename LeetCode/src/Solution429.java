import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-08-9:18
 */
//public class Solution429 {
//    public List<List<Integer>> levelOrder(Node root) {
//        if(root == null) return new ArrayList<>();
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.add(root);
//        List<List<Integer>> res = new ArrayList<>();
//        while (!queue.isEmpty()){
//            List<Integer> l = new ArrayList<>();
//            int size = queue.size();
//            while (size>0){
//                Node poll = queue.poll();
//                l.add(poll.val);
//                if(poll.children != null){
//                    for(Node n : poll.children){
//                        queue.add(n);
//                    }
//                }
//                size--;
//            }
//            res.add(l);
//        }
//        return res;
//    }
//}
