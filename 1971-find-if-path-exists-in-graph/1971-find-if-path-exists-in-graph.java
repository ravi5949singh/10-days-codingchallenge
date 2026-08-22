class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Integer>[] graph = new ArrayList[n];

        // Create graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, source, destination, visited);
    }

    public boolean dfs(ArrayList<Integer>[] graph, int src, int dest, boolean[] visited) {

        // Destination mil gaya
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        // Neighbours visit karo
        for (int neighbour : graph[src]) {

            if (!visited[neighbour]) {
                if (dfs(graph, neighbour, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}