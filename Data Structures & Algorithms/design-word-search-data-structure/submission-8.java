class TreeNode {
    Map<Character, TreeNode> children;
    boolean isEnd;

    public TreeNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class WordDictionary {

    TreeNode root;
    public WordDictionary() {
        this.root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode node = root;
        for (char ch : word.toCharArray()) {
            // will not replace if another word starts with same letter
            node.children.computeIfAbsent(ch, k -> new TreeNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TreeNode root) {
        TreeNode node = root;
        for (int i = j; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character == '.') {
                for (char ch : node.children.keySet()) {
                    if (node.children.containsKey(ch) && dfs(word, i+1, node.children.get(ch))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.children.containsKey(character)) {
                    return false;
                }
                node = node.children.get(character);
            }
        }
        return node.isEnd;
    }
}
