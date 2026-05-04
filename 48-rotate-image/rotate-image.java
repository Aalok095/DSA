class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int a = 0,b = n-1;
            while(a<b){
                int temp = mat[i][a];
                mat[i][a] = mat[i][b];
                mat[i][b] = temp;
                a++;b--;
            }
        }
    }
}