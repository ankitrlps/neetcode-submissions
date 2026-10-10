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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        List<Integer> vals = new ArrayList<>();
        for (ListNode node : lists) {
            
            while (node != null) {
                vals.add(node.val);
                node = node.next;
            }
        }

        vals.sort(Comparator.naturalOrder());
        ListNode res = new ListNode();
        ListNode prev = res;
        for (int val : vals) {
            prev.next = new ListNode(val);
            prev = prev.next;
        }

        return res.next;
    }
}
