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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // BFS
        // Queue<TreeNode> que = new LinkedList<>();
        // que.add(root);
        // while (que.size() > 0) {
        //     var node = que.poll();
        //     TreeNode left = node.left;
        //     node.left = node.right;
        //     node.right = left;
            
        //     if (node.left != null) que.add(node.left);
        //     if (node.right != null) que.add(node.right);
        // }

        // DFS
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
