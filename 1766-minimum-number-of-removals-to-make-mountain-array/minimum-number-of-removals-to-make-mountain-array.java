class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] dp1 = new int[n];// increasing 
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[j]<nums[i]) dp1[i] = Math.max(dp1[i],dp1[j]);
            }
            dp1[i] += 1;
        }

        int[] dp2 = new int[n];// decreasing
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[j]<nums[i]) dp2[i] = Math.max(dp2[i],dp2[j]);
            }
            dp2[i] += 1;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1){ // end points are mf dont consider them they can never be peak
                int len = dp1[i]+dp2[i]-1;
                max = Math.max(max,len);
            }
        }
        if(max<3) return 0;
        return n-max;
    }
}