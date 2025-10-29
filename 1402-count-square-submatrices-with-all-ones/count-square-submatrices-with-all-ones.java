class Solution {
    public int countSquares(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        int c = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) continue;
                if(i>0 && j>0){
                    mat[i][j] += Math.min(mat[i-1][j],Math.min(mat[i-1][j-1],mat[i][j-1]));
                }
                c += mat[i][j];
            }
        }
        return c;
    }
}