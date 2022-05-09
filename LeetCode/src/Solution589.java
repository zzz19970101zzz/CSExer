import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-10-9:07
 */
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//}
//public class Solution589 {
//    public List<Integer> preorder(Node root) {
//        List<Integer> res = new ArrayList<>();
//
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            while (size-->0){
//                Node poll = queue.poll();
//                res.add(poll.val);
//                if(!poll.children.isEmpty()){
//                    for (int i = 0; i < poll.children.size(); i++) {
//                        queue.add(poll.children.get(i));
//                    }
//                }
//            }
//        }
//        return res;
//    }
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> preorder1(Node root) {
//
//        dfs(root);
//        return list;
//    }
//
//    public void dfs(Node root){
//        if(root == null){
//            return;
//        }
//        list.add(root.val);
//        for (int i = 0; i < root.children.size(); i++) {
//            dfs(root.children.get(i));
//        }
//    }
//}
