class Solution {
  Set<Integer> visited = new HashSet<>();
  Map<Integer, List<Integer>> map = new HashMap<>();
  public int countComponents(int n, int[][] edges) {
    for (int i = 0; i < n; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int[] edge : edges) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }

    int connected = 0;
    for (int edge : map.keySet()) {
      if (!visited.contains(edge)) {
        dfs(edge);
        connected++;
      }
    }

    return connected;
  }

  private void dfs(int edge) {
    if (visited.contains(edge)) {
      return;
    }
    visited.add(edge);
    for (int nei : map.get(edge)) {
      dfs(nei);
    }
  }
}
