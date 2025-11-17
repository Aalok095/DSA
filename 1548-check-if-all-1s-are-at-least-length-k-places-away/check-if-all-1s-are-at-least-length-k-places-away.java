class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int last1 = -(k+1);
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                if(i-last1-1 < k) return false;
                last1 = i;
            }
        }
        return true;
    }
}