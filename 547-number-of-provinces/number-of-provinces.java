class Solution {
    public void bfs(int i,int[][] adj,boolean[] vis){
        int n = adj.length;
        vis[i] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int j=0;j<n;j++){
                if(adj[temp][j]==1 && !vis[j]){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length, c = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,adj,vis);
                c++;
            }
        }
        return c;
    }
}