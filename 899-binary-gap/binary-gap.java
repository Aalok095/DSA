class Solution {
    public int binaryGap(int n) {
        int curr = 0,prev = -1;
        int ans = 0;
        while(n>0){
            if((n&1)>0){
                ans = prev!=-1 ? Math.max(ans,curr-prev) : ans;
                prev = curr;
            }
            curr++;
            n>>=1;
        }
        return ans;
    }
}