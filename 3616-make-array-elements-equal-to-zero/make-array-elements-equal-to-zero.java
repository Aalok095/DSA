class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length,res = 0;
        int S = 0;

        for(int ele : nums) S += ele;

        int  currSum = 0;
        for(int i=0;i<n;i++){
            currSum += nums[i];

            int l = currSum;
            int r = S - currSum;

            if(nums[i]!=0) continue;
            if(l==r) res += 2;
            else if(Math.abs(l-r)==1) res++;
        }
        return res;
    }
}