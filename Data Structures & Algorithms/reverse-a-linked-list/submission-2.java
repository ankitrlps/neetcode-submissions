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
    public ListNode reverseList(ListNode head) {
        // if (head == null) return null;
        // ListNode prev = new ListNode(head.val);
        // head = head.next;
        // while (head != null) {
        //     ListNode currNew = new ListNode(head.val);
        //     currNew.next = prev;
        //     prev = currNew;
        //     head = head.next;
        // }
        // return prev;


        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
