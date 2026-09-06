class Solution {
    
    public int helper(String s, String t, int i, int j, int[][] dp){
        if(i==t.length()) return 1;
        if(j==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int take=0;
        if(s.charAt(j)==t.charAt(i)){
            take= helper(s,t,i+1,j+1,dp);
        }
        int nonTake= helper(s,t,i,j+1,dp);

        return dp[i][j]=take+nonTake;
    }

    public int numDistinct(String s, String t) {
        int[][] dp=new int[t.length()+1][s.length()+1];
        for(int[] x:dp)Arrays.fill(x,-1);
        return helper(s,t,0,0,dp);
    }
}