import java.util.*;

class ReverseList {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    /**
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // null <- 1 <- 2 <-3 <- 4 <- 5
    */
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null)
            return null;
        // 头插法反转链表
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // null <- 1 <- 2 <-3 <- 4 <- 5
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy.next;
        ListNode cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pre;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        
    }
}
