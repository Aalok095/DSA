class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long mul = 1;
        long sum = 0;
        long limit = (long)1e14;

        long[] suf = new long[nums.length+1];
        Arrays.fill(suf,1);

        for(int i = nums.length-1;i>=0;i--){
            if(suf[i+1] > limit / nums[i]) suf[i] = limit + 1;
            else suf[i] = suf[i+1] * nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            mul = suf[i+1];
            if(sum == mul) return i;
            sum += nums[i];
        }
        return -1;
    }
}