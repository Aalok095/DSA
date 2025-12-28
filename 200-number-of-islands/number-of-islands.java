class Solution {
    public void bfs(char[][] grid,int r,int c){
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        grid[r][c] = '0';

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                    grid[nx][ny] = '0';
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int c = 0;
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1') {
                    c++;
                    bfs(grid,i,j);// bye bye mf 
                }
            }
        }
        return c;
    }
}