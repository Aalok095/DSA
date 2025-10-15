class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int prevSum = 0;
        int currSum = 1;
        int k = 0;
        for(int i=0;i<n-1;i++){
            if(nums.get(i)<nums.get(i+1)) currSum++;
            else{
                prevSum = currSum;
                currSum = 1;
            }
            if(currSum/2>k) k = currSum/2;
            int a = Math.min(currSum,prevSum);
            if(a>k) k = a;
        }
        return k;
    }
}