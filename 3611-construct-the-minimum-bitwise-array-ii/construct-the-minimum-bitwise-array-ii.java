class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(nums.get(i)==2){
                    ans[i] = -1;
                    continue;
                }
            for(int j=1;j<32;j++){
                if((nums.get(i) & (1<<j))>0) continue; // jth bit is set
                ans[i] = nums.get(i) ^ (1<<(j-1));
                flag = true;
                break;
            }
            if(!flag) ans[i] = -1;
        }
        return ans;
    }
}