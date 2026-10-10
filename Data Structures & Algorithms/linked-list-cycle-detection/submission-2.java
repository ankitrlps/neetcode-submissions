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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode rabbit = head.next.next;
        ListNode tortoise = head.next;

        while (tortoise != null && rabbit != null && rabbit.next != null) {
            if (rabbit == tortoise) return true;
            rabbit = rabbit.next.next;
            tortoise = tortoise.next;
        }
        return false;
    }
}
