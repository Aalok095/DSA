class Solution {
    public double solve(int p,int i,int j,double[][] dp){
        if(i<0 || j<0 || i<j) return 0.0;
        if(i==0 && j==0) return p;
        if(dp[i][j]!=-1.1) return dp[i][j];
        double upleft = (solve(p,i-1,j-1,dp)-1)/2.0;
        double upright = (solve(p,i-1,j,dp)-1)/2.0;

        if(upleft<0) upleft = 0.0;
        if(upright<0) upright = 0.0;
        
        return dp[i][j] = upleft + upright;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        for(double[] row : dp) Arrays.fill(row,-1.1);
        return Math.min(1.0,solve(poured,query_row,query_glass,dp));
    }
}