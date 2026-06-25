class Solution {
    public int countMajoritySubarrays(int[] nums, int t) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = nums[i]==t ? 1 : -1;
        int[] pre = new int[n+1];
        for(int i=0;i<n;i++) pre[i+1] = pre[i]+arr[i];
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(pre[i+1]-pre[j]>0) c++;
            }
        }
        return c;
    }
}