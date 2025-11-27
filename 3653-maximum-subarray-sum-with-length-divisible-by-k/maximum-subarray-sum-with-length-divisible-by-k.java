class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] pre = new long[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++) pre[i] = pre[i-1]+nums[i];

        long res = Long.MIN_VALUE;
        // kadaens Algorithm
        for(int start=0;start<k;start++){ //why till k-1 , cause repition starts after that
            long currSum = 0; 
            int i = start;
            while(i<n && i+k-1<n){
                int j = i+k-1;// k sized window maintain stuff 
                long subSum = pre[j]-((i>0) ? pre[i-1] : 0);
                currSum = Math.max(subSum , currSum + subSum);// naya se chalu karu ya append kar du purane wale mai ? kadane questions
                res = Math.max(res,currSum);
                i += k; 
            }
        }
        return res;
    }
}