class Solution {
    public int countSubstrings(String s) {
        int n = s.length(),c = 0;
        int[][] dp = new int[n][n];

        for(int k=0;k<n;k++){

            int i = 0, j = k;
            while(j<n){

                if(i==j){// 1 length palindrome
                    dp[i][j] = 1;
                    c++;
                } 

                else if (j==i+1){// 2 length palindrome
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 1;
                        c++;
                    }
                }

                else {// more than 2 length palindrome
                    if(s.charAt(i)==s.charAt(j)){
                        if(dp[i+1][j-1]==1){
                            dp[i][j] = 1;
                            c++;
                        }  
                    }
                }
                i++;j++;
            }
        }
        return c;
    }
}