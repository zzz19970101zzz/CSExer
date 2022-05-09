import java.util.HashMap;

/**
 * @author zzz
 * @create 2022-04-11-22:03
 */
//public class Offer35 {
//    public Node copyRandomList(Node head) {
//        if(head == null) return head;
//        HashMap<Node, Node> map = new HashMap<>();
//        Node temp = head;
//        Node newHead = new Node(head.val);
//        Node temp1 = newHead;
//        while (temp != null){
//            map.put(temp,temp1);
//            temp1.next = temp.next == null ? null :new Node(temp.next.val);
//            temp = temp.next;
//            temp1 = temp1.next;
//        }
//        temp = head;temp1=newHead;
//        while (temp!= null){
//            temp1.random = map.get(temp.random);
//            temp = temp.next;
//            temp1 = temp1.next;
//        }
//        return newHead;
//    }
//}
//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}
