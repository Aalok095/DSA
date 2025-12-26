class Solution {
    public void bfs(int start,int end,boolean[] vis,List<List<Integer>> adj){
        vis[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int ele : adj.get(temp)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele] = true;
                    if(ele==end) return;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        // making adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            int a = e[0], b = e[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];
        bfs(start,end,vis,adj);
        return vis[end];
    }
}