class Solution {
    Map<Integer,TreeSet<Integer>> componentStations = new HashMap<>();
    private void dfs(int node,Map<Integer,List<Integer>> adj,int[] visited,int componentId,int[] componentOf){
        visited[node] = 1;
        componentOf[node] = componentId;

        componentStations.putIfAbsent(componentId, new TreeSet<>());
        componentStations.get(componentId).add(node);

        for (int neighbor : adj.getOrDefault(node,new ArrayList<>())) {
            if (visited[neighbor] == 0) {
                dfs(neighbor,adj,visited,componentId,componentOf);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer,List<Integer>> adj = new HashMap<>();

        // Build adjacency list
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u,k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k -> new ArrayList<>()).add(u);
        }
        int[] visited = new int[c+1];
        int[] componentOf = new int[c+1];

        // DFS to assign component ids
        for (int node = 1; node <= c; node++) {
            if (visited[node] == 0) {
                dfs(node,adj,visited,node,componentOf);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        // Process queries
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            int compId = componentOf[x];
            TreeSet<Integer> set = componentStations.get(compId);

            if (type == 1) {
            if (set.contains(x)) resultList.add(x);
            else if (!set.isEmpty()) resultList.add(set.first());
            else resultList.add(-1);
            }
            else set.remove(x); //offline
        }

        int[] result = new int[resultList.size()];
        for (int i = 0;i < result.length;i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}