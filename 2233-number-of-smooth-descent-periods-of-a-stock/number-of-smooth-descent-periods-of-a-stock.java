class Solution {
    public long getDescentPeriods(int[] p) {
        int n = p.length;
        long ans = n;
        int len = 0;
        for(int i=1;i<n;i++){
            if(p[i-1]-p[i]==1){
                len++;
                ans += len;
            }
            else len = 0;
        }
        return ans;
    }
}