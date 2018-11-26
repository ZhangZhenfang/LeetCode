package _23_Merge_K_Sorted_List;

/**
 * @author ZhangZhenfang
 * @date 2018/11/26 22:33
 */
public class Solution {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        lists[0] = listNode;
        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        lists[1] = listNode;
        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        lists[2] = listNode;

        listNode = new Solution().mergeKLists(lists);

        while(listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        boolean stop;
        int min, index;
        while (true) {
            stop = true;
            min = Integer.MAX_VALUE;
            index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    stop = false;
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        index = i;
                    }
                }
            }

            if (stop) {
                break;
            } else {
                p.next = lists[index];
                p = p.next;
                lists[index] = lists[index].next;
            }
        }
        return res.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + "";
    }
}
