class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // appraoch reverse the graph + kahn's algo
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>(); // reverse graph
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] in = new int[n];
        for(int i=0;i<n;i++){
            for(int ele : graph[i]){
                // in original graph , edge is from i to ele  
                // in reverse graph, edge is from ele to i;
                adj.get(ele).add(i);
                in[i]++; 
            }
        }
        // kahn's algo 
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);
        while(q.size()>0){
            int front = q.poll();
            ans.add(front);
            for(int ele : adj.get(front)){
                in[ele]--;
                if(in[ele]==0) q.add(ele);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}