class Solution {
    public long maxLength(int i,List<Integer> nums,int target,int[][] dp){
        if(i==nums.size()){
            if(target==0) return 0;
            else return Integer.MIN_VALUE; 
        }
        if(dp[i][target]!=-1) return dp[i][target];
        long skip = maxLength(i+1,nums,target,dp);
        if(target-nums.get(i)<0) return skip;
        long take = 1 + maxLength(i+1,nums,target-nums.get(i),dp);
        return dp[i][target] = (int) Math.max(skip,take);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        int ans = (int)maxLength(0,nums,target,dp);
        return ans < 0 ? -1 : ans;
    }
}