class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last1 = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(last1 != -1 && i-last1-1 < k) return false;
                last1 = i;
            }
        }
        return true;
    }
}