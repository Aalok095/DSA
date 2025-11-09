class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(),maxLen = 1,st = 0; 
        int[][] dp = new int[n][n];
        for(int k=0;k<n;k++){
            int i=0,j=k;
            while(j<n){
                if(i==j) dp[i][j] = 1;
                else if(j==i+1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 1;
                        if(maxLen<2){
                            maxLen = 2;
                            st = i;
                        }
                    }
                }
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                        if(maxLen < j-i+1) {
                            maxLen = j-i+1;
                            st = i;
                        }
                    }
                i++;j++;
            }
        }
        return s.substring(st,st+maxLen);
    }
}