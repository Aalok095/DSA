class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[nums[i]]++;
        }
        int[] ans = new int[2];
        int j = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==2) ans[j++] = i;
        }
        return ans;
    }
}