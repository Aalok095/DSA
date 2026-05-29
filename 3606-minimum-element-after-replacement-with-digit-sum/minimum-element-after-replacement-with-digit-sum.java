class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int a = nums[i];
            int r = 0;
            while(a!=0){
                r+=(a%10);
                a/=10;
            }
            min = Math.min(min,r);
        }
        return min;
    }
}