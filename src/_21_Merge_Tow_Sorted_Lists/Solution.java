package _21_Merge_Tow_Sorted_Lists;

public class Solution {

    public static void main(String[] args){
        Solution s = new Solution();

        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(5);
//        l2.next.next.next = new ListNode(6);

        ListNode res = s.mergeTwoLists(l1, l2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /**
         * important
         */
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode res = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                res.next = l2;
                res = res.next;
                l2 = l2.next;

            }
            else{
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }
        }
        if(l1 == null){
            res.next = l2;
        }
        else{
            res.next = l1;
        }
        return head.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
