class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dist[i][j] = Integer.MAX_VALUE;

        for(int[] e : edges){
            int u = e[0],v = e[1], wt = e[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }  

        // Floyd Warshal
        for(int k=0;k<n;k++){ // through k
            for(int i=0;i<n;i++){
                if(i==k) continue;
                for(int j=0;j<n;j++){
                    if(j==k) continue;
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE)
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int minCity = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int c = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(dist[i][j]<=threshold) c++;
            }
            if(c<=min){
                min = c;
                minCity = i;
            }
        }   
        return minCity;   
    }
}