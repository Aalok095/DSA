class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length,n = grid[0].length;

        int[][] sum = new int[m][n];
        int[][] xCnt = new int[m][n];
        int c = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

            int val = (grid[i][j] == 'X') ? 1 : (grid[i][j] == 'Y') ? -1 : 0;
            int x = (grid[i][j] == 'X') ? 1 : 0;

            sum[i][j] = val;
            xCnt[i][j] = x;

            if(i > 0){
                sum[i][j] += sum[i-1][j];
                xCnt[i][j] += xCnt[i-1][j];
            }

            if(j > 0){
                sum[i][j] += sum[i][j-1];
                xCnt[i][j] += xCnt[i][j-1];
            }

            if(i > 0 && j > 0){
                sum[i][j] -= sum[i-1][j-1];
                xCnt[i][j] -= xCnt[i-1][j-1];
            }

            if(sum[i][j] == 0 && xCnt[i][j] > 0) c++;

            }
        }
        return c;
    }
}