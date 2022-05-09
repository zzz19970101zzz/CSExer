package com.zzz.contest;

import org.junit.Test;

/**
 * @author zzz
 * @create 2022-02-20-23:25
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution0220_2 {
    public ListNode mergeNodes(ListNode head) {

        ListNode temp = head;
        int sum  = 0;
        ListNode node = temp;
        while (temp != null){
            if(temp.val == 0){
                if(temp.next == null){
                    node.val = sum;
                    node.next = null;
                    break;
                }
                temp = temp.next;
                node.next = temp;
                node.val = sum;
                node = temp;
                sum = 0;
                continue;
            }
            sum += temp.val;
            temp = temp.next;
        }
        return head.next;
    }
    @Test
    public void test(){
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next= new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next= new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(0);

        System.out.println(mergeNodes(head).val);
    }
}
