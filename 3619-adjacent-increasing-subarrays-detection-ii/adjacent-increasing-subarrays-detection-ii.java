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
            k = Math.max(k,currSum/2);
            k = Math.max(k,Math.min(prevSum,currSum));
        }
        return k;
    }
}