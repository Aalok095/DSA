class Solution {
    int count = 0;
    private int dfs(int curr, int parent,Map<Integer, List<Integer>> adj,int[] values, int k) {
        int sum = 0;
        for (int ngbr : adj.get(curr)) {
            if (ngbr != parent) {
                sum += dfs(ngbr,curr,adj,values,k);
                sum %= k;
            }
        }
        sum += values[curr];
        sum %= k;
        if (sum == 0) count++;
        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for (int i = 0;i < n;i++) adj.put(i,new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        count = 0;
        dfs(0,-1,adj,values,k);
        return count;
    }
}