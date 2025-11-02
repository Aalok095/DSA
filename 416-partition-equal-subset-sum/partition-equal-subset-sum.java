class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0,n = nums.length;
        for(int ele : nums) sum+=ele;
        if(sum%2!=0) return false;

        int target = sum/2;
        //i -> 0 to n-1 | target -> target to 0
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<target+1;j++){
                boolean ans = false;
                boolean skip = i>0 ? dp[i-1][j]==1 : j==0;//j->target;
                if(j-nums[i]<0) ans = skip;
                else {
                    boolean pick = i>0 ? dp[i-1][j-nums[i]]==1 : j==0;
                    ans = pick || skip;
                }
                dp[i][j] = ans ? 1 : 0;
            }
        }
        return dp[n-1][target]==1;
    }
}