//Question: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// Time Complexity = O(V+E)
// Space Complexity = O(V+E)

class Solution {
    Map<Integer, List<Integer>> map;
    int[] visited;

    public int countComponents(int n, int[][] edges) {
        if (edges == null) return 0;
        int count = 0;
        map = new HashMap<>();
        visited = new int[n];

        for (int[] edge: edges) {
            if (!map.containsKey(edge[0])) {
                map.put (edge[0], new ArrayList());
            }
            map.get(edge[0]).add(edge[1]);

            if (!map.containsKey(edge[1])) {
                map.put (edge[1], new ArrayList());
            }
            map.get(edge[1]).add(edge[0]);
        }

        for (int key: map.keySet()) {
            if (visited[key] == 0) {
                dfs(key);
                count++;
            }
        }

        for (int i=0; i<n; i++) {
            if (!map.containsKey(i)) count++;
        }

        return count;
    }

    private void dfs(int key) {
        // base
        if (visited[key] == 1) return;

        // logic
        List<Integer> values = map.get(key);
        visited[key] = 1;
        for (int val: values) {
            dfs(val);
        }
    }
}