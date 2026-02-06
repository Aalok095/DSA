class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i=0;
        int maxlen = 1;// trying to find max len bal array then subtract that from n;
        for(int j=0;j<n;j++){
            long maxEl = nums[j];
            long minEl = nums[i];

            while (i<j  && maxEl>(long)k*minEl) {
                i++;
                minEl = nums[i];
            }
            maxlen = Math.max(maxlen,j-i+1);
        }
        return n-maxlen;
    }
}