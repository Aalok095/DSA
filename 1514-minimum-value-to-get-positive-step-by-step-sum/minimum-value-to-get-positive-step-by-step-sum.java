class Solution {
    public int minStartValue(int[] nums) {
        int  mps=0,sum = 0; // mps -> minimum prefix sum
        for(int ele : nums){
            sum+=ele;
            mps = Math.min(sum,mps);
        }
        return 1-mps;
    }
}