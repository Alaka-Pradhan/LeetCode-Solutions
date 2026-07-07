class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites)
            graph.get(pre[1]).add(pre[0]);

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(graph, state, i))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int node) {
        state[node] = 1;

        for (int next : graph.get(node)) {
            if (state[next] == 1)
                return true;

            if (state[next] == 0) {
                if (dfs(graph, state, next))
                    return true;
            }
        }

        state[node] = 2;
        return false;
    }
}