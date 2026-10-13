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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] preorderIndex = {0};
        return dfs(preorder, 0, inorder.length - 1, preorderIndex, map);
    }

    private TreeNode dfs(
        int[] preorder, int l, int r, int[] preorderIndex, Map<Integer, Integer> map) {
        if (l > r)
            return null;

        int root_val = preorder[preorderIndex[0]++];
        TreeNode root = new TreeNode(root_val);
        int inorder_mid_index = map.get(root_val);
        root.left = dfs(preorder, l, inorder_mid_index - 1, preorderIndex, map);
        root.right = dfs(preorder, inorder_mid_index + 1, r, preorderIndex, map);
        return root;
    }
}
