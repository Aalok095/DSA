class Solution {
    public void bfs(int i,List<List<Integer>> adj,boolean[] vis){
        vis[i] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int ele : adj.get(temp)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                } 
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        bfs(0,adj,vis);
        for(boolean ele : vis) if(!ele) return false;
        return true;
    }
}