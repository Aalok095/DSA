class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j] && nums[i]==nums[k]){
                        ans = Math.min(ans,Math.abs(j-i)+Math.abs(j-k)+Math.abs(k-i));
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}