class Solution {
    public long minimumOperations(int[] nums, int[] t) {
        int n = nums.length;
        long prev = 0,op = 0;
        for(int i=0;i<n;i++){
            long curr = t[i]-nums[i];
            if((prev < 0 && curr > 0) || (prev > 0 && curr < 0)) op += Math.abs(curr);
            else if(Math.abs(curr)>Math.abs(prev)) op += (Math.abs(curr-prev));
            prev = curr;
        }
        return op;
    }
}