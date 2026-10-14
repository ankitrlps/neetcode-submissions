class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prereq) {

        // Basing on numcourses instead of prereq[][]
        for (int i = 0; i <= numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // adding prerequisites for courses
        for (int[] pre : prereq) {
            map.get(pre[0]).add(pre[1]);
        }

        // looping through main courses and dfs-ing on its prereq
        for (int course : map.keySet()) {
            if (!dfs(course))
                return false;
        }
        return true;
    }

    // takes main course and recurse on its prereq
    private boolean dfs(int course) {
        if (visited.contains(course)) {
            // detected a cycle
            return false;
        };

        if (map.get(course).isEmpty()) {
            // no more pre req are available
            return true;
        }

        // adding course to visited -- used in detecting cycle
        visited.add(course);
        for (int pre : map.get(course)) {
            if (!dfs(pre))
                return false;
        }
        // if there's no cycle, remove the visited course
        visited.remove(course);

        // emptying main course prereq as there's no cycle
        map.put(course, new ArrayList<>());

        return true;
    }
}
