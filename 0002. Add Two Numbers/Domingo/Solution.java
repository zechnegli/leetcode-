/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        int carrier = 0;
        int bitSum = 0;
        ListNode preNode = sum;
        while (l1 != null && l2 != null) {
            bitSum = l1.val + l2.val + carrier;
            ListNode newNode = new ListNode(bitSum % 10);
            preNode.next = newNode;
            preNode = newNode;
            carrier = (bitSum >= 10)? 1 : 0;
            l1 = l1.next; l2 = l2.next;
        }
        
        if (l1 == null && l2 == null) {
            if (carrier == 1) {
                preNode.next = new ListNode(1);
            }
        } else if (l1 == null) {
            while (l2 != null) {
                bitSum = l2.val + carrier;
                preNode.next = new ListNode(bitSum % 10);
                carrier = (bitSum >= 10)? 1 : 0;
                preNode = preNode.next;
                l2 = l2.next;
            }
            if (carrier == 1) {
                preNode.next = new ListNode(1);
            }
        } else if (l2 == null) {
            while (l1 != null) {
                bitSum = l1.val + carrier;
                preNode.next = new ListNode(bitSum % 10);
                carrier = (bitSum >= 10)? 1 : 0;
                preNode = preNode.next;
                l1 = l1.next;
            }
            if (carrier == 1) {
                preNode.next = new ListNode(1);
            }
        }
        return sum.next;
    }
}