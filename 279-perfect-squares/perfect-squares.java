class Solution {
    public boolean isPerfect(int n){
        int sqrt = (int)Math.sqrt(n);
        return sqrt*sqrt==n;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            if(isPerfect(i)) dp[i] = 1;
            else {
                int min = i;
                for(int j=1;j*j<=i;j++){
                    int count = dp[j*j] + dp[i-j*j];
                    min = Math.min(min,count);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}

// rec + memo - T.C n*root n

// class Solution {
//     public boolean isPerfect(int n){
//         int sqrt = (int)Math.sqrt(n);
//         return sqrt*sqrt==n;
//     }
//     public int minSquares(int n,int[] dp) {
//         if(isPerfect(n)) return 1;
//         if(dp[n]!=-1) return dp[n];
//         int min = n;// 96 ka ans 96 ho sakta hai max 1..1...1......1....1... * 96 times
//         for(int i=1;i*i<=n;i++){
//             int count = minSquares(i*i,dp) + minSquares(n-i*i,dp);
//             min = Math.min(min,count);
//         }
//         return dp[n] = min;
//     }
//     public int numSquares(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return minSquares(n,dp);
//     }
// }