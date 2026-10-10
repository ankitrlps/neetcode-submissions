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
    public void reorderList(ListNode head) {
         ListNode slow = head;
         ListNode fast = head.next;

         while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
         }

        ListNode runner = slow.next;
        slow.next = null;
        ListNode prev = null;
        
        while (runner != null) {
            ListNode temp = runner.next;
            runner.next = prev;
            prev = runner;
            runner = temp;
        }
        
        ListNode headRunner = head;
        ListNode reverseRunner = prev;

        // [2,4,6]
        // [10,8]
        while (reverseRunner != null) {
            ListNode temp1 = headRunner.next;
            ListNode temp2 = reverseRunner.next;
            
            headRunner.next = reverseRunner;
            reverseRunner.next = temp1;

            headRunner = temp1;
            reverseRunner = temp2;
        }
    }
}
