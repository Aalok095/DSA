class Solution {
    static boolean ans;
    public void bfs(int i,int[][] graph,int[] vis){
        vis[i] = 0;// 0 -> blue, 1 -> red
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.poll();
            int color = vis[front];
            for(int ele : graph[front]){
                if(vis[ele]==color){
                    ans = false;
                    return;
                }
                if(vis[ele]==-1){
                    vis[ele] = 1-color;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        ans = true;
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++){
            if(!ans) return ans; 
            if(vis[i]==-1) bfs(i,graph,vis);
        }
        return ans;
    }
}