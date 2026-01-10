class Solution {
    public int helper(int i,int j,int m,int n,String s1,String s2,int[][] dp){
        if(i>=m && j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i>=m) return dp[i][j] = s2.charAt(j) + helper(i,j+1,m,n,s1,s2,dp);
        if(j>=n) return dp[i][j] = s1.charAt(i) + helper(i+1,j,m,n,s1,s2,dp);
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = helper(i+1,j+1,m,n,s1,s2,dp);
        int takes1 = s1.charAt(i) + helper(i+1,j,m,n,s1,s2,dp);
        int takes2 = s2.charAt(j) + helper(i,j+1,m,n,s1,s2,dp);
        return dp[i][j] = Math.min(takes1,takes2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,0,m,n,s1,s2,dp);
    }
}