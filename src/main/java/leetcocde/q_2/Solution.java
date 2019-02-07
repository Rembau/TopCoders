package leetcocde.q_2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(4);
        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.print(listNode.val);
        while (listNode.next != null) {
            System.out.print(listNode.next.val);
            listNode = listNode.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tem = l1.val + l2.val;
        int record = tem / 10;
        ListNode ln1 = new ListNode(tem % 10);
        ListNode ln = ln1;
        while (l1.next != null) {
            if (l2.next != null) {
                tem = l1.next.val + l2.next.val + record;
                System.out.println(tem);
                ln.next = new ListNode(tem % 10);
                record = tem / 10;
                l1 = l1.next;
                l2 = l2.next;
                ln = ln.next;
            } else {
                ln.next = l1.next;
                break;
            }
        }
        if (l2.next != null) {
            ln.next = l2.next;
        }
        while (record != 0) {
            if (ln.next == null) {
                ln.next = new ListNode(record);
                break;
            }
            int tem1 = ln.next.val + record;
            ln.next.val = tem1 % 10;
            record = tem1 / 10;
            ln = ln.next;
        }
        return ln1;
    }
}