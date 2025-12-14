class Solution {
    public int absDifference(int[] nums, int k) {
        int n = nums.length;
        if(k==n) return 0;
        Arrays.sort(nums);
        int a = 0,b = n-1;
        int sl = 0,sr = 0;
        for(int i=0;i<k;i++){
            sl+=nums[a++];
            sr+=nums[b--];
        }
        return sr-sl;
    }
}