class Solution {

    int M = (int)1e9 + 7;
    int[][][] dp;

    int solve(int i, int j, int last, int limit) {

        if (i == 0 && j == 0) return 0;

        // only zeros left
        if (j == 0) {
            if (last == 1) return 0;
            return (i <= limit) ? 1 : 0;
        }

        //  only ones left
        if (i == 0) {
            if (last == 0) return 0;
            return (j <= limit) ? 1 : 0;
        }

        if (dp[i][j][last] != -1) return dp[i][j][last];

        int result = 0;
        if (last == 0) {
            result = (solve(i-1, j, 0, limit) + solve(i-1, j, 1, limit)) % M;
            if (i > limit) result = (result - solve(i-1-limit, j, 1, limit) + M) % M;
        } else {
            result = (solve(i, j-1, 0, limit) + solve(i, j-1, 1, limit)) % M;
            if (j > limit) result = (result - solve(i, j-1-limit, 0, limit) + M) % M;
        }
        return dp[i][j][last] = result;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new int[zero+1][one+1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (solve(zero,one,0,limit) + solve(zero,one,1,limit)) % M;
    }
}
