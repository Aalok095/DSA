class Solution {
    public boolean isInc(List<Integer> nums,int lo,int hi){
        for(int i=lo;i<hi;i++){
            if(nums.get(i)>=nums.get(i+1)) return false;
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i=0;i+2*k<=n;i++){
            if(isInc(nums,i,i+k-1) && isInc(nums,i+k,i+2*k-1)) return true;
        }
        return false;
    }
}