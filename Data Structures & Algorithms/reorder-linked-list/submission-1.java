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
        ListNode headRunner = head;
        List<ListNode> list = new ArrayList<>();

        while (headRunner != null) {
            list.add(headRunner);
            headRunner = headRunner.next;
        }
        int i = 0;
        int j = list.size()-1;
        
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i >= j) break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
