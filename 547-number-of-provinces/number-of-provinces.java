class Solution {
    static int[] parent;
    static int[] size;

    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int a,int b){
        int leaderA = find(a);
        int leaderB = find(b);
        // if leadA == leadB then there is a cycle so do nothing
        if(leaderA != leaderB) {
            if(size[leaderA]>size[leaderB]){ // a should be parent of b 
            parent[leaderB] = leaderA;
            size[leaderA] += size[leaderB];
            }
            else{
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
            } 
        } 
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        parent = new int[n+1]; // 1 based indexing
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        } 
        parent[0] = 69;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // edge is from i+1 to j+1
                if(i!=j && isConnected[i][j]==1)union(i+1,j+1); // conntecting group leaders of i+1 and j+1;
            }
        }
        
        int c = 0;
        for(int i=1;i<=n;i++) if(parent[i]==i) c++;
        return c;
    }
}