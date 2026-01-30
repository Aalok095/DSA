class Solution {
    static class Edge {
        String to;
        long cost;
        Edge(String t, long c) {
            to = t;
            cost = c;
        }
    }

    // Graph: string -> list of (nextString, cost)
    Map<String, List<Edge>> graph = new HashMap<>();

    // Cache for Dijkstra results: start -> (end -> cost)
    Map<String, Map<String, Long>> distCache = new HashMap<>();

    TreeSet<Integer> lens = new TreeSet<>(); // valid substring lengths
    String src, tgt;
    long[] dp;

    long INF = (long) 1e15;

    //DIJKSTRA
    long shortest(String start, String end) {
        if (distCache.containsKey(start) && distCache.get(start).containsKey(end)) {
            return distCache.get(start).get(end);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.cost));
        Map<String,Long> dist = new HashMap<>();

        pq.add(new Edge(start,0));
        dist.put(start, 0L);

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            String node = cur.to;
            long cost = cur.cost;

            if (node.equals(end)) break;
            if (!graph.containsKey(node)) continue;

            for (Edge e : graph.get(node)) {
                long newCost = cost + e.cost;
                if (newCost < dist.getOrDefault(e.to, INF)) {
                    dist.put(e.to, newCost);
                    pq.add(new Edge(e.to, newCost));
                }
            }
        }

        long ans = dist.getOrDefault(end, INF);
        distCache.computeIfAbsent(start, k -> new HashMap<>()).put(end, ans);
        return ans;
    }

    //DP ON STRING 
    long dfs(int i) {
        if (i == src.length()) return 0;
        if (dp[i] != -1) return dp[i];

        long ans = INF;

        // Case 1: characters already same
        if (src.charAt(i) == tgt.charAt(i)) ans = dfs(i + 1);

        // Case 2: try substring transformations
        for (int len : lens) {
            if (i + len > src.length()) break;

            String sSub = src.substring(i,i + len);
            String tSub = tgt.substring(i,i + len);

            if (!graph.containsKey(sSub)) continue;

            long c = shortest(sSub, tSub);
            if (c == INF) continue;

            ans = Math.min(ans,c + dfs(i + len));
        }
        return dp[i] = ans;
    }

    public long minimumCost(String source, String target,String[] original, String[] changed, int[] cost) {

        src = source;
        tgt = target;

        dp = new long[source.length()];
        Arrays.fill(dp,-1);

        // Build graph
        for (int i = 0; i < original.length; i++) {
            graph.computeIfAbsent(original[i], k -> new ArrayList<>()).add(new Edge(changed[i],cost[i]));
            lens.add(original[i].length());
        }

        long ans = dfs(0);
        return ans >= INF ? -1 : ans;
    }
}
