package _19_Remove_Nth_Node_From_End_Of_List;

public class Solution {

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode res = s.removeNthFromEnd(node, 4);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head;
        ListNode second = head;

        while(n > 0){
            first = first.next;
            n--;
        }
        if(first == null){
            return head.next;
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
