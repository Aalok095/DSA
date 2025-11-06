class Solution {
    public int LCS(String t1,String t2,int m,int n,int[][] dp){
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(t1.charAt(m)==t2.charAt(n)) return dp[m][n] = 1 + LCS(t1,t2,m-1,n-1,dp);
        else return dp[m][n] = Math.max(LCS(t1,t2,m-1,n,dp),LCS(t1,t2,m,n-1,dp));
    }
    public int longestCommonSubsequence(String t1, String t2) {
        int m = t1.length(),n = t2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return LCS(t1,t2,m-1,n-1,dp);
    }
    public int minDistance(String w1, String w2) {
        int m = w1.length(),n = w2.length();
        return m+n-2*longestCommonSubsequence(w1,w2);
    }
}