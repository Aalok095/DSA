class Solution {
    public int minOperations(int[] nums, int k) {
        int s = 0;
        for(int ele : nums) s+=ele;
        return s%k;
    }
}