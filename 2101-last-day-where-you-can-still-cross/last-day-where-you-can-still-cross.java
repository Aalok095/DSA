class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean bfs(int[][] grid,int i,int j,int row,int col){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        grid[i][j] = 1;
        while(!q.isEmpty()){
            int[] front = q.poll();
            int x = front[0];
            int y = front[1];
            if(x==row-1) return true;
                for(int[] dir : directions){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 0) {
                        q.add(new int[]{nx,ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
            return false;
        }
    public boolean canCross(int[][] cells,int day,int row,int col){

        int[][] grid = new int[row][col];

        for(int i=0;i <= day;i++){// sinking land
            int x = cells[i][0]-1;
            int y = cells[i][1]-1;
            grid[x][y] = 1;
        }

        for(int j=0;j<col;j++){
            if(grid[0][j] == 0 && bfs(grid,0,j,row,col)) return true;
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0, r = cells.length-1;
        int ans = 0;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(canCross(cells,mid,row,col)){
                ans = mid+1;
                l = mid+1;
            } 
            else r = mid-1;
        }
        return ans;
    }
}