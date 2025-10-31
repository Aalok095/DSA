class Solution {
    public int ways(int m,int n,int[][] obs,int[][] dp){
        if(m<0 || n<0 || obs[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n] = ways(m-1,n,obs,dp)+ways(m,n-1,obs,dp);
    }
    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length, n = obs[0].length; 
        if(obs[0][0]==1 || obs[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return ways(m-1,n-1,obs,dp);    
    }
}