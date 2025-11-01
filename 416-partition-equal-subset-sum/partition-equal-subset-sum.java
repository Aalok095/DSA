class Solution {
    public boolean subset(int i,int[] arr,int target,int[][] dp){
        if(i==arr.length) return target==0;
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean ans = false;
        boolean skip = subset(i+1,arr,target,dp);
        if(target-arr[i]<0) ans = skip;
        else {
            boolean pick = subset(i+1,arr,target-arr[i],dp);
            ans = skip || pick;
        }
        dp[i][target] = ans ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum+=ele;
        if(sum%2!=0) return false;

        int target = sum/2;
        //i -> 0 to n-1 | target -> target to 0
        int[][] dp = new int[nums.length][target+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return subset(0,nums,target,dp);
    }
}