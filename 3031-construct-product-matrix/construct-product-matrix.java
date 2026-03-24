class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int MOD = 12345;
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];

        long suffix = 1;
        for (int i = m - 1;i >= 0;i--) {      // Suffix product
            for (int j = n - 1;j >= 0;j--) {
                ans[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }

        long prefix = 1;
        for (int i = 0;i < m;i++) {     //Prefix product
            for (int j = 0;j < n;j++) {
                ans[i][j] = (int)((prefix * ans[i][j]) % MOD);
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }
        return ans;
    }
}