class Solution {
    public long solve(int i,int trend,int[] nums,long[][] dp){
        int n = nums.length;
        if(i==n){
            return trend == 3 ? 0 : Long.MIN_VALUE/2;
        }

        if(dp[i][trend]!=Long.MIN_VALUE) return dp[i][trend];
        long take = Long.MIN_VALUE/2;
        long skip = Long.MIN_VALUE/2;

        if(trend==0){
            skip = solve(i+1,0,nums,dp);
        }

        if(trend == 3) take = nums[i]; // trionic pattern completed we can end here
        
        if(i+1<n){
            int curr = nums[i];
            int next = nums[i+1];

            if(trend==0 && next>curr) {
                take = Math.max(take,curr + solve(i+1, 1,nums,dp));
            }

            else if(trend==1){
                if (next > curr) {
                    take = Math.max(take,curr + solve(i+1,1,nums,dp));
                } else if (next < curr) {
                    take = Math.max(take,curr + solve(i+1,2,nums,dp));
                }
            }

            else if (trend == 2) {
                if (next < curr) {
                    take = Math.max(take, curr + solve(i+1,2,nums,dp));
                } else if (next > curr) {
                    take = Math.max(take, curr + solve(i+1,3,nums,dp));
                }
            } 
            
            else if (trend == 3 && next > curr) {
                take = Math.max(take, curr + solve(i+1,3,nums,dp));
            }
        }
        return dp[i][trend] = Math.max(take,skip);
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long[][] dp = new long[n][4];
        for(long[] row : dp) Arrays.fill(row,Long.MIN_VALUE);

        return solve(0,0,nums,dp);
    }
}