class Solution {
    Integer[][][] dp;
    public int solve(int i, int j, int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (i >= m || j >= n) return -1;

        k -= (grid[i][j] == 2 ? 1 : grid[i][j]);
        if (k < 0) return -1;

        if (i == m - 1 && j == n - 1) return grid[i][j];
        if (dp[i][j][k] != null) return dp[i][j][k];

        int r = solve(i + 1, j, grid, k);
        int d = solve(i, j + 1, grid, k);

        int res;
        if (r == -1 && d == -1) res = -1;
        else if (r == -1) res = grid[i][j] + d;
        else if (d == -1) res = grid[i][j] + r;
        else res = grid[i][j] + Math.max(r, d);

        return dp[i][j][k] = res;
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        dp = new Integer[m][n][k + 1];
        return solve(0, 0, grid, k);
    }
}