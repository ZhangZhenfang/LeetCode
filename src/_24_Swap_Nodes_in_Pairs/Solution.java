package _24_Swap_Nodes_in_Pairs;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

/**
 * @author ZhangZhenfang
 * @date 2019/3/2 12:25
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        ListNode p = head;
//        while(p != null) {
//            System.out.println(p.val);
//            p = p.next;
//        }
        head = new Solution().swapPairs(head);
        p = head;
        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode p = head.next;
            head.next = null;
            p.next = head;
            return p;
        }
        ListNode s = head;
        ListNode q, p;
        head = head.next;
        while(true) {
            p = s;
            q = p.next;
            p.next = p.next.next.next;
            s = q.next;
            q.next = p;
            if (s.next == null) {
                p.next = s;
                return head;
            }
            if (s.next.next == null) {
                s.next.next = s;
                s.next = null;
                return head;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
