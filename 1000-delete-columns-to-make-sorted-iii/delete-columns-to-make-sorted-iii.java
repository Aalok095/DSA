class Solution {
    public int minDeletionSize(String[] s) {
        int m = s.length;
        int n = s[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int LIS = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                boolean flag = true;
                for(int k=0;k<m;k++){
                    if(s[k].charAt(j)>s[k].charAt(i)){
                        flag = false;
                        break;
                    }
                }
                if(flag) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            LIS = Math.max(LIS,dp[i]);
        }
        return n - LIS;
    }
}