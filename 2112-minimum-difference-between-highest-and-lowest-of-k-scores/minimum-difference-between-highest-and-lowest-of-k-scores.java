class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return 0;
        Arrays.sort(nums);
        int ans = nums[k-1]-nums[0];
        for(int i=0;i+k<=n;i++) ans = Math.min(nums[i+k-1]-nums[i],ans);
        return ans;
    }
}