class Solution {
    int M = 1000000007;
    String[] states = {"RYG","RGY","RYR","RGR","YRG","YGR","YGY","YRY","GRY","GYR","GRG","GYG"};
    public int helper(int n,int prev,int[][] dp){
        if(n==0) return 1;
        if(dp[n][prev]!=-1) return dp[n][prev];

        String l = states[prev];
        int res = 0;
        for(int i=0;i<12;i++){
            if(i==prev) continue;
            String curr = states[i];
            boolean flag = false;
            for(int j=0;j<3;j++){
                if(curr.charAt(j)==l.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(!flag) res = (res+helper(n-1,i,dp)) % M;
        }
        return dp[n][prev] = res;
    }
    public int numOfWays(int n) {
        int[][] dp = new int[n][12];
        for(int[] row : dp) Arrays.fill(row,-1);
        int res = 0;
        for(int i=0;i<12;i++){
            res = (res+helper(n-1,i,dp))%M;
        }
        return res;
    }
}