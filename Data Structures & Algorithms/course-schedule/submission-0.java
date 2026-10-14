class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prereq) {

        for (int i = 0; i <= numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prereq) {
            map.get(pre[0]).add(pre[1]);
        }
        //System.out.println(map);

        for (int course : map.keySet()) {
            if (!dfs(course)) return false;
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) return false;
        
        if (map.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for (int pre : map.get(course)) {
            if (!dfs(pre)) return false;
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());

        return true;
    }
}
