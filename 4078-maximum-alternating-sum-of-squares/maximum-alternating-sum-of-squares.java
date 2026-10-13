class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0) nums[i] = (-1)*nums[i];
        }
        Arrays.sort(nums);
        long s = 0;
        for(int i=0;i<n/2;i++){
            s -= (nums[i]*nums[i]);
        }
        for(int i=n/2;i<n;i++){
            s += (nums[i]*nums[i]);
        }
        return s;
    }
}