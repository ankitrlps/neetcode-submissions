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
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        Queue<TreeNode> pp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();

        pp.add(p);
        qq.add(q);

        while (!pp.isEmpty() && !qq.isEmpty()) {
            TreeNode pnode = pp.poll();
            TreeNode qnode = qq.poll();

            if ((pnode.left == null && qnode.left != null)
                || (pnode.left != null && qnode.left == null))
                return false;

            if ((pnode.right == null && qnode.right != null)
                || (pnode.right != null && qnode.right == null))
                return false;

            if (pnode.val != qnode.val)
                return false;

            if (pnode.left != null) {
                pp.add(pnode.left);
            }

            if (qnode.left != null) {
                qq.add(qnode.left);
            }

            if (pnode.right != null) {
                pp.add(pnode.right);
            }

            if (qnode.right != null) {
                qq.add(qnode.right);
            }
        }

        return true;
    }
}
