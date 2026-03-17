class Solution {
    public int largestSubmatrix(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1 && i>0){
                    mat[i][j] += mat[i-1][j];// cumm 1's
                }
            }
            int[] currRow = mat[i].clone();
            Arrays.sort(currRow);
            for (int col = 0;col < n;col++) {
                int b = n-col;
                int h = currRow[col];
                res = Math.max(res,b*h);
            }
        }
        return res;
    }
}