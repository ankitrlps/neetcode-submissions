class TreeNode {
  Map<Character, TreeNode> children;
  boolean isEnd;

  public TreeNode() {
    this.children = new HashMap<>();
    this.isEnd = false;
  }
}

class PrefixTree {
  TreeNode root;

  public PrefixTree() {
    this.root = new TreeNode();
  }

  public void insert(String word) {
    TreeNode node = root;
    for (char ch : word.toCharArray()) {
      node.children.putIfAbsent(ch, new TreeNode());
      node = node.children.get(ch);
    }
    node.isEnd = true;
  }

  public boolean search(String word) {
    TreeNode node = root;
    for (char ch : word.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        return false;
      }
      node = node.children.get(ch);
    }
    return node.isEnd;
  }

  public boolean startsWith(String prefix) {
    TreeNode node = root;
    for (char ch : prefix.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        return false;
      }
      node = node.children.get(ch);
    }
    return true;
  }
}
