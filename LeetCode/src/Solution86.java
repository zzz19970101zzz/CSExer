import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-02-18-22:39
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution86 {
    public ListNode partition(ListNode head, int x) {

        LinkedList<ListNode> list1 = new LinkedList<>();
        LinkedList<ListNode> list2 = new LinkedList<>();

        ListNode temp = head;
        while (temp != null){
            if(temp.val < x) list1.add(temp);
            else list2.add(temp);
            temp = temp.next;
        }
        ListNode res = new ListNode();
        ListNode temp1= res;
        while (!list1.isEmpty() ){
            temp1.next = list1.pollFirst();
            temp1 = temp1.next;
        }
        while (!list2.isEmpty() ){
            temp1.next = list2.pollFirst();
            temp1 = temp1.next;
        }
        temp1.next = null;
        System.out.println();
        return res.next;
    }
    @Test
    public void test(){
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next= new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);

        System.out.println(partition(l, 3));
    }
}
