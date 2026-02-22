class Solution {
    public int scoreDifference(int[] nums) {
        int n = nums.length;
        boolean f = true;
        int fp = 0,sp = 0;
        for(int i=0;i<n;i++){
            if(nums[i]%2 != 0) f = !f;
            if((i+1)%6==0) f = !f;
            if(f) fp += nums[i];
            else sp += nums[i];
        }
        return fp-sp;
    }
}