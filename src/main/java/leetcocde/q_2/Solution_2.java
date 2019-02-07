package leetcocde.q_2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution_2 {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(1);
        ListNode listNode = new Solution_2().addTwoNumbers(l1, l2);
        System.out.print(listNode.val);
        while (listNode.next != null) {
            System.out.print(listNode.next.val);
            listNode = listNode.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null?l2:l1;
        }

        ListNode record = null;
        ListNode current = null;
        int carry = 0;
        while (true) {

            if (l1 == null) {
                if (carry == 0) {
                    current.next = l2;
                } else {
                    current.next = addTwoNumbers(new ListNode(carry), l2);
                }
                return record;
            } else if (l2 == null) {
                if (carry == 0) {
                    current.next = l1;
                } else {
                    current.next = addTwoNumbers(l1, new ListNode(carry));
                }
                return record;
            }

            int sum = l1.val + l2.val + carry;

            carry = sum / 10;
            ListNode tem = new ListNode(sum % 10);
            if (record == null) {
                record = tem;
                current = record;
            } else {
                current.next = tem;
                current = current.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }
    }
}