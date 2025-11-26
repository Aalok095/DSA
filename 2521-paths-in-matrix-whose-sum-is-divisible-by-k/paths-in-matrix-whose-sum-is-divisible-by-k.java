class Solution {
    int M = 1_000_000_007;
    Integer[][][] dp; 

    int solve(int row, int col, int CurrSum, int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || col >= n) return 0;

        if (row == m-1 && col == n-1) return ((CurrSum + grid[row][col]) % k == 0) ? 1 : 0;
        if (dp[row][col][CurrSum] != null) return dp[row][col][CurrSum];

        int newRemain = (CurrSum + grid[row][col]) % k;

        int down  = solve(row + 1, col,newRemain, grid, k);
        int right = solve(row, col + 1,newRemain, grid, k);

        return dp[row][col][CurrSum] = (int)(((long)down + right) % M);
    }

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        dp = new Integer[m][n][k];

        return solve(0, 0, 0, grid, k);
    }
}