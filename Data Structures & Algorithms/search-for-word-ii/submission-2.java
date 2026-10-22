class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class Solution {
    
    TrieNode root;
    Set<String> res;
    int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public Solution() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            //System.out.println("added" + ch);
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(char ch, TrieNode node) {
        //System.out.println(ch + " " + node.children.containsKey(ch));
        return node.children.containsKey(ch);
    }

    // traverse using DFS 
    // mark cell as visited
    // search in Trie and check if word ended
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        res = new HashSet<>();
        Arrays.stream(words).forEach(word -> addWord(word));
        //wordsSet = Set.of(words); // to match and then save in res
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, visited, root, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int i, int j, char[][] board, boolean[][] visited, TrieNode node, String word) {
        if (visited[i][j]) return;

        //System.out.println(i + " " + j + " " + node.isEnd);
        if (search(board[i][j], node)) {
            node = node.children.get(board[i][j]);
            word += board[i][j];
            if (node.isEnd) res.add(word);
            visited[i][j] = true;
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) {
                    continue;
                }
                dfs(x, y, board, visited, node, word);
            }
            visited[i][j] = false;
        }
    }
}
