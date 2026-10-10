/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head;
        int len = 0;

        while (runner != null) {
            len++;
            runner = runner.next;
        }

        runner = head;
        int index = -1;
        ListNode prev = null;
        while (runner != null) {
            index++;
            if (index == len - n) {
                if (index == 0) {
                    return runner.next;
                }
                prev.next = runner.next;

            } else {
                prev = runner;
            }
            runner = runner.next;
        }

        return head;
    }
}
