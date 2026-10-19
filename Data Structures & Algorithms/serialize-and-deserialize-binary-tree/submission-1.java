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

public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return "";

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    while (!que.isEmpty()) {
        TreeNode node = que.poll();
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val).append(",");
            que.add(node.left);
            que.add(node.right);
        }
    }
    System.out.println("sb: " + sb.toString());
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0)
      return null;
    String[] split = data.split(",");
    TreeNode res = new TreeNode(Integer.parseInt(split[0]));
    Queue<TreeNode> que = new LinkedList<>();
    que.add(res);
    int index = 1;

    while (!que.isEmpty()) {
        TreeNode node = que.poll();
        if (!split[index].equals("null")) {
            node.left = new TreeNode(Integer.parseInt(split[index]));
            que.add(node.left);
        }
        index++;
        if (!split[index].equals("null")) {
            node.right = new TreeNode(Integer.parseInt(split[index]));
            que.add(node.right);
        }
        index++;
    }
    return res;
  }
}
