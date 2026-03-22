class Solution {
    public int[][] rotate(int[][] mat){ // transpose + swap
        int m = mat.length;
        int[][] tran = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                tran[j][i] = mat[i][j];
            }
        }
        for(int j=0;j<m;j++){
            int a = 0,b = m-1;
            while(a<b){
                int temp = tran[a][j];
                tran[a][j] = tran[b][j];
                tran[b][j] = temp;
                a++;b--;
            }
        }
        return tran;
    }
    public boolean findRotation(int[][] mat, int[][] t) {
        for(int i = 0;i < 4;i++) {
            if(Arrays.deepEquals(mat,t)) return true;
            mat = rotate(mat);  
        }
        return false;
    }
}