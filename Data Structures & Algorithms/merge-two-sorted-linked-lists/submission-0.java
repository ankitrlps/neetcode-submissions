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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode res = new ListNode();
        ListNode currRes = res;
        //ListNode prev = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ListNode curr = new ListNode(list1.val);
                list1 = list1.next;
                currRes.next = curr;
                currRes = currRes.next;
            } else {
                ListNode curr = new ListNode(list2.val);
                list2 = list2.next;
                currRes.next = curr;
                currRes = currRes.next;
            }
        }

        while (list1 != null) {
            currRes.next = new ListNode(list1.val);
            list1 = list1.next;
            currRes = currRes.next;
        }
        
        while (list2 != null) {
            currRes.next = new ListNode(list2.val);
            list2 = list2.next;
            currRes = currRes.next;
        }

        return res.next;
    }
}