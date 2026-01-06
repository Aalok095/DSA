class Solution {
    static boolean ans;
    public void dfs(int i,List<List<Integer>> adj,boolean[] path,boolean[] vis){
        vis[i]=true;
        path[i] = true;
        for(int ele : adj.get(i)){
            if(path[ele]){
                ans = false;
                return;
            }
            if(!vis[ele])dfs(ele,adj,path,vis);
        }
        path[i] = false;
    }
    public boolean canFinish(int n, int[][] prereq) {
        ans = true; // true -> np cycle
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] p : prereq){
            int a = p[0],b = p[1]; // b -> a edge ja rahi hai
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        // dfs 
        for(int i=0;i<n;i++){
            if(!vis[i]) dfs(i,adj,path,vis);
        }
        return ans;
    }
}