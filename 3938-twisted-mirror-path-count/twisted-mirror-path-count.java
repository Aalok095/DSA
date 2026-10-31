class Solution {
    int LEFT = 0; 
    int UP = 1;   
    int MOD = 1_000_000_007;
    int m; 
    int n; 
    
    int solve(int[][] grid, int i, int j, int cameFrom, int[][][] t) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (t[i][j][cameFrom] != -1) return t[i][j][cameFrom];
        
        if (grid[i][j] == 1) { // mirror
            if (cameFrom == LEFT) {
                return t[i][j][cameFrom] = solve(grid, i + 1, j, UP, t);
            } else {
                return t[i][j][cameFrom] = solve(grid, i, j + 1, LEFT, t);
            }
        }

        // grid[i][j] == 0
        int totalPathsCount = 0;
        totalPathsCount = (totalPathsCount + solve(grid, i, j + 1, LEFT, t)) % MOD;
        totalPathsCount = (totalPathsCount + solve(grid, i + 1, j, UP, t)) % MOD;

        return t[i][j][cameFrom] = totalPathsCount;
    }

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][][] t = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j][0] = -1;
                t[i][j][1] = -1;
            }
        }
        return solve(grid, 0, 0, LEFT, t);
    }
}