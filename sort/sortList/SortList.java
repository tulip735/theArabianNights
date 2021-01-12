import java.util.*;


public class SortList {

   public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
      Sort a linked list in O(n log n) time using constant space complexity.
      Input: 4->2->1->3
      Output: 1->2->3->4

    */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;

        ListNode l = sortList(head);
        ListNode r = sortList(fast);
        return mergeList(l, r);
    }

    private static ListNode mergeList(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
                p = p.next;
            } else {
                p.next = r;
                r = r.next;
                p = p.next;
            }
        }

        while (l != null) {
            p.next = l;
            l = l.next;
            p = p.next;
        }

        while (r != null) {
            p.next = r;
            r = r.next;
            p = p.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        
        int[] nums = new int[] {4, 2, 1, 3};
        for (int x : nums) {
            p.next = new ListNode(x);
            p = p.next;
        }

        head = sortList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        
    }
}
