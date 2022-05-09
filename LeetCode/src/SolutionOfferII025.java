import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * @author zzz
 * @create 2022-03-17-18:01
 */
public class SolutionOfferII025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null){
            s1.push(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null){
            s2.push(temp2);
            temp2 = temp2.next;
        }
        int jinwei = 0;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (!s1.isEmpty() && !s2.isEmpty()){
            ListNode l = new ListNode();
            int i = s1.pop().val;
            int j = s2.pop().val;
            int sum = i + j + jinwei;
            if(sum >=10){
                l.val = sum%10;
                jinwei=1;
            }else {
                jinwei=0;
                l.val = sum;
            }
            if(temp==head){
                temp.next = l;
                temp = temp.next;
            }else {
                head.next = l;
                l.next = temp;
                temp = l;
            }
        }
        if(s1.isEmpty()){
            while (!s2.isEmpty()){
                ListNode pop = s2.pop();
                if(jinwei !=0){
                    pop.val++;
                    if(pop.val >=10){
                        pop.val %= 10;
                        jinwei =1;
                    }else
                    jinwei = 0;
                }
                pop.next = temp;
                head.next = pop;
                temp = pop;
            }
        }else {
            while (!s1.isEmpty()){
                ListNode pop = s1.pop();
                if(jinwei !=0){
                    pop.val++;
                    if(pop.val >=10){
                        pop.val %= 10;
                        jinwei =1;
                    }else
                        jinwei = 0;
                }
                pop.next = temp;
                head.next = pop;
                temp = pop;
            }
        }
        if(jinwei != 0) head.val = 1;
        return head.val == 1? head:head.next;
    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(3);
//        l2.next.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
