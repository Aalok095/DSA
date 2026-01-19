class Solution {
    public int maxSideLength(int[][] mat, int t) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pre = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pre[i][j] = mat[i][j] + (i>0 ? pre[i-1][j] : 0) + (j>0 ? pre[i][j-1] : 0) - (i>0 && j>0 ? pre[i-1][j-1] : 0);
            }
        }
        int side = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=side;k<Math.min(m-i,n-j);k++){ // offset
                    int r2 = i + k;
                    int c2 = j + k;

                    int sum = pre[r2][c2];
                    if (i > 0) sum -= pre[i-1][c2];
                    if (j > 0) sum -= pre[r2][j-1];
                    if (i > 0 && j > 0) sum += pre[i-1][j-1];
                    if(sum<=t) side = k+1;
                    else break;
                }
            }
        }
        return side;
    }
}