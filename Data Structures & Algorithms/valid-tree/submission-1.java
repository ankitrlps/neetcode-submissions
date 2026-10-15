class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        // 0 -> [1, 2, 3]
        // 1 -> [4]
        // 2 -> []
        // 3 -> []
        // 4 -> []

        // O(N)
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        // O(N)
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return dfs(0, -1) && visited.size() == n;
    }

    private boolean dfs(int edge, int prev) {
        if (visited.contains(edge)) {
            // cycle detected
            return false;
        }
        visited.add(edge);
        for (int currEdge : map.get(edge)) {
            if (currEdge == prev)
                continue;
            if (!dfs(currEdge, edge))
                return false;
        }
        return true;
    }
}
