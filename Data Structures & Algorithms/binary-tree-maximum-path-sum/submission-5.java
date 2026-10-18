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
    public int maxPathSum(TreeNode root) {
        int[] res = {root.val};
        dfs(root, res);
        return res[0];
    }

// All three below things are w.r.t each node:

// 1. we calculate max of left and right 
// (with 0 because when there's negative values on left/right
// we don't want negatives to count hence max compare with 0)

// 2. then we update the res by max comparing with  
// curr node + left + right
// because at that node left + node + right,
// we got the max value -- we aren't thinking about path here
// as in what's to return from that node

// 3. When returning from a node, we calculate what's the
// max path we got from left vs right and add node's val
// so that that path will be used by parent to add more
    private int dfs(TreeNode node, int[] res) {
        if (node == null) return 0;

        int left = dfs(node.left, res);
        int right = dfs(node.right, res);
        int leftMax = Math.max(0, left);
        int rightMax = Math.max(0, right);

        res[0] = Math.max(res[0], node.val + leftMax + rightMax);
        return node.val + Math.max(leftMax, rightMax);
    }
}
