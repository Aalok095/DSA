class Solution {
    public long rob(int[] nums, int[] c) {
        int n = nums.length;
        if(n==1) return nums[0];
        long[] dp = new long[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        if(c[0]!=c[1]) dp[1] = Math.max(dp[1],nums[0]+nums[1]);// imp

        for(int i=2;i<n;i++){
            long take = nums[i]+dp[i-2];
            long skip = dp[i-1];
            if(c[i]!=c[i-1]) take = Math.max(nums[i]+dp[i-1],take);
            dp[i] = Math.max(take,skip);
        }
        return dp[n-1];
    }
}