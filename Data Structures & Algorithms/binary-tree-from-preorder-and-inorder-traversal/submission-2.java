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
    int preorder_index = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r)
            return null;

        int root_val = preorder[preorder_index++];
        TreeNode root = new TreeNode(root_val);
        int inorder_mid_index = map.get(root_val);
        root.left = dfs(preorder, l, inorder_mid_index - 1);
        root.right = dfs(preorder, inorder_mid_index + 1, r);
        return root;
    }
}
