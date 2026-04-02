class Solution {
    public int solve(int i, int j, int[][] coins, int k, int[][][] dp) {
        int m = coins.length, n = coins[0].length;

        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] >= 0) return coins[i][j];
            return (k > 0) ? 0 : coins[i][j];
        }

        if (dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];

        int down, right;

        if (coins[i][j] >= 0) {
            down = solve(i + 1, j, coins, k, dp);
            right = solve(i, j + 1, coins, k, dp);

            int best = Math.max(down, right);
            if (best == Integer.MIN_VALUE) return dp[i][j][k] = Integer.MIN_VALUE;

            return dp[i][j][k] = coins[i][j] + best;
        } else {
            down = solve(i + 1, j, coins, k, dp);
            right = solve(i, j + 1, coins, k, dp);

            int loss = Integer.MIN_VALUE;
            int best = Math.max(down,right);
            if (best != Integer.MIN_VALUE) loss = coins[i][j] + best;

            int skip = Integer.MIN_VALUE;
            if (k > 0) {
                down = solve(i + 1, j, coins, k - 1, dp);
                right = solve(i, j + 1, coins, k - 1, dp);
                skip = Math.max(down, right);
            }
            return dp[i][j][k] = Math.max(loss, skip);
        }
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return solve(0, 0, coins, 2, dp);
    }
}