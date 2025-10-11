class Solution {
    public int minSubArrayLen(int t, int[] nums) {
        int n = nums.length;
        int minlen = Integer.MAX_VALUE;
        int sum = 0;
        int i=0,j=0;
        while(j<n){
            sum += nums[j];

            //chota karna chah rahe hai window ko
            while(sum >= t){
                minlen = Math.min(minlen,j-i+1);
                sum -= nums[i];
                i++;
            }

            j++;
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}