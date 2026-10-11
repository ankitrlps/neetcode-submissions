/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        pp.add(p);
        qq.add(q);

        while (!pp.isEmpty() && !qq.isEmpty()) {
            TreeNode pnode = pp.poll();
            TreeNode qnode = qq.poll();

            if (pnode == null && qnode == null)
                continue;
            if (pnode == null || qnode == null || pnode.val != qnode.val)
                return false;
            
            pp.add(pnode.left);
            qq.add(qnode.left);
            pp.add(pnode.right);
            qq.add(qnode.right);
        }

        return true;
    }
}
