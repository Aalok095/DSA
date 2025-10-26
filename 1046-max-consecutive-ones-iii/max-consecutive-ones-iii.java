class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i=0,res = 0,zeroes = 0;
        for(int j=0;j<n;j++){
            if(nums[j]==0) zeroes++;
            while(zeroes>k){
                if(nums[i++]==0) zeroes--;
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}