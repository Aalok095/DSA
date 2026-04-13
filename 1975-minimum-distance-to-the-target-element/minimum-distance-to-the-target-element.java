class Solution {
    public int getMinDistance(int[] nums, int t, int s) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==t) min = Math.min(min,Math.abs(i-s));
        }
        return min;
    }
}