import java.util.LinkedList;

/**
 * @author zzz
 * @create 2022-08-15-19:56
 */
public class Solution641 {

    public static void main(String[] args) {
        MyCircularDeque1 m = new MyCircularDeque1(3);
        m.insertLast(1);
        m.insertLast(2);
        m.insertFront(3);
    }
}
class MyCircularDeque {

    int size ;
    LinkedList<Integer> list;
    public MyCircularDeque(int k) {
        size = k;
        list = new LinkedList<>();
    }

    public boolean insertFront(int value) {
        if(list.size() >= size)
            return false;
        list.addFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if(list.size() >= size)
            return false;
        list.add(value);
        return true;
    }

    public boolean deleteFront() {
        if(list.size() == 0)
            return false;
        list.removeFirst();
        return true;
    }

    public boolean deleteLast() {
        if(list.size() == 0)
            return false;
        list.removeLast();
        return true;
    }

    public int getFront() {
        if(list.size() == 0)
            return -1;
        return list.get(0);
    }

    public int getRear() {
        if(list.size() == 0)
            return -1;
        return list.getLast();
    }

    public boolean isEmpty() {

        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == size;
    }
}



class MyCircularDeque1 {

    int[] nums;
    int front = -1;
    int end = -1;
    public MyCircularDeque1(int k) {
        nums = new int[k];
    }

    public boolean insertFront(int value) {
        if(isFull())
            return false;
        boolean flag = false;
        if(isEmpty()){
         flag = true;
        }
        front = front == 0 ? nums.length -1 : front -1;
        if(flag)
            end = front == nums.length - 1 ? 0 : front + 1;
        nums[front]=value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
            return false;
        boolean flag = false;
        if(isEmpty()){
            flag = true;
        }
        end = end == nums.length - 1 ? 0 : end + 1;
        if(flag)
            front = end == 0 ? nums.length - 1 : end - 1;
        nums[end]=value;
        return true;
    }

    public boolean deleteFront() {
       if(isEmpty())
           return false;
       front = front == 0 ? nums.length - 1 : front - 1;
       return true;
    }

    public boolean deleteLast() {
        if(isEmpty())
            return false;
        end = end == 0 ? nums.length - 1 : end - 1;
        return true;
    }

    public int getFront() {
        if(isEmpty())
            return -1;
        return nums[front];
    }

    public int getRear() {
        if(isEmpty())
            return -1;
        return nums[end];
    }

    public boolean isEmpty() {
        return front == end;
    }

    public boolean isFull() {
       if(front ==0 && end == nums.length -1)
           return true;
       if(front - 1 == end)
           return true;
       return false;
    }
}