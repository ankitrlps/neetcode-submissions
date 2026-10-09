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
                currRes.next = list1;
                list1 = list1.next;
            } else {
                currRes.next = list2;
                list2 = list2.next;
            }
            currRes = currRes.next;
        }

        if (list1 != null) {
            currRes.next = list1;
        } else {
            currRes.next = list2;
        }

        return res.next;
    }
}