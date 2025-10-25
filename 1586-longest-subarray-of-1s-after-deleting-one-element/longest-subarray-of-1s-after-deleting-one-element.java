class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i=0,j=0,lastZeroIndex = -1,res = 0;
        while(j<n){
            if(nums[j]==0){
                i = lastZeroIndex+1;
                lastZeroIndex = j;
            }
            res = Math.max(res,j-i);
            j++;
        }
        return res;
    }
}