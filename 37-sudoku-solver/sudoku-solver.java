class Solution {
    public boolean isValid(char[][] grid,int row,int col,char d){
        for(int i=0;i<9;i++){
            if(grid[i][col]==d) return false;
            if(grid[row][i]==d) return false;
        }
        int start_i = row/3*3;
        int start_j = col/3*3;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(grid[start_i+k][start_j+l]==d) return false;
            }
        }
        return true;
    }
    public boolean solve(char[][] grid){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j]=='.'){
                    for(char d='1';d<='9';d++){
                        if(isValid(grid,i,j,d)){
                            grid[i][j] = d;
                            if(solve(grid)) return true;
                            grid[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}