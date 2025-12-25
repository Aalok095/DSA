class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        Arrays.sort(hap);
        long a = 0,ans = 0;
        int i = hap.length-1;
        while(k-- > 0){
            ans += hap[i]-a <=0 ? 0 : hap[i]-a;
            a++;
            i--;
        }
        return ans;
    }
}