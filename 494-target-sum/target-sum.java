class Solution {
    public int ways(int i,int[] arr,int target){
        if(i==arr.length) return target==0 ? 1 : 0;
        int add = ways(i+1,arr,target-arr[i]);
        int sub = ways(i+1,arr,target+arr[i]);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(0,nums,target);
    }
}