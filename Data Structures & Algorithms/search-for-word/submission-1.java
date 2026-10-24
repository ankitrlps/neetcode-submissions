class Solution {
  // loop through each cell
  // transform the word to charArray();
  // if first letter is equivalent to iteration cell
  // do the direction search and only increment the charArray if !visited and each value if equal
  // once charArray is completed, return true

  int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  boolean[][] visited;
  public boolean exist(char[][] board, String word) {
    this.visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs(i, j, board, 0, word)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean dfs(int i, int j, char[][] board, int k, String word) {
    if (k == word.length())
      return true;

    if (i < 0 || j < 0 || i == board.length || j == board[0].length
        || board[i][j] != word.charAt(k) || visited[i][j]) {
      return false;
    }

    visited[i][j] = true;
    for (int[] direction : directions) {
      int x = i + direction[0];
      int y = j + direction[1];

      if (dfs(x, y, board, k + 1, word)) {
        return true;
      }
    }
    visited[i][j] = false;
    return false;
  }
}
