class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length,rsum = 0;
        for(int ele : nums) rsum += ele;
        int lsum = 0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            rsum-=nums[i];
            ans[i] = Math.abs(rsum-lsum);
            lsum+=nums[i];
        }
        return ans;
    }
}