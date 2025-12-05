class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++) pre[i] = pre[i-1]+nums[i];
        int c = 0;
        for(int i=0;i<n-1;i++){
            int lsum = pre[i]; 
            int rsum = pre[n-1] - pre[i];
            if(Math.abs(lsum-rsum)%2==0) c++;
        }
        return c;
    }
}