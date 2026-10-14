class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int col = 0; col < COLS; col++) {
            dfs(0, col, pac, heights);
            dfs(ROWS - 1, col, atl, heights);
        }

        for (int row = 0; row < ROWS; row++) {
            dfs(row, 0, pac, heights);
            dfs(row, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (pac[row][col] && atl[row][col]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(row);
                    list.add(col);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, boolean[][] ocean, int[][] heights) {
        ocean[x][y] = true;

        for (int[] direction : directions) {
            int xx = direction[0];
            int yy = direction[1];

            if (x + xx < 0 || y + yy < 0 || x + xx == heights.length || y + yy == heights[0].length
                || ocean[x + xx][y + yy] || heights[x][y] > heights[x + xx][y + yy]) {
                continue;
            }
            dfs(x + xx, y + yy, ocean, heights);
        }
    }
}
