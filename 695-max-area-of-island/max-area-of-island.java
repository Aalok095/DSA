class Solution {
    public int bfs(int r, int c, int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        grid[r][c] = 0;

        int area = 1;
        int[][] dir = {{0,-1},{-1,0},{1,0},{0,1}};

        while (!q.isEmpty()) {
            int[] f = q.poll();
            int x = f[0],y = f[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) continue;
                q.add(new int[]{nx, ny});
                grid[nx][ny] = 0; 
                area++;
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxA = 0;

        for (int i = 0;i < m; i++) {
            for (int j = 0;j < n; j++) {
                if (grid[i][j] == 1) maxA = Math.max(maxA,bfs(i,j,grid));
            }
        }
        return maxA;
    }
}
