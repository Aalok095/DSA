class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length,n = grid[0].length;
        int layers = Math.min(m,n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> nums = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            // Top row (left -> right)
            for (int j = left; j <= right; j++) {
                nums.add(grid[top][j]);
            }

            // Right column (top -> bottom) skip corners otherwise overwrite nigg@
            for (int i = top + 1; i <= bottom - 1; i++) {
                nums.add(grid[i][right]);
            }

            // Bottom row (right -> left)
            for (int j = right; j >= left; j--) {
                nums.add(grid[bottom][j]);
            }

            // Left column (bottom -> top)
            for (int i = bottom - 1; i >= top + 1; i--) {
                nums.add(grid[i][left]);
            }

            int len = nums.size();
            int K = k % len; 

            // Rotate left by normalizedK
            Collections.rotate(nums,-K);

            int idx = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                grid[top][j] = nums.get(idx++);
            }

            // Right column
            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = nums.get(idx++);
            }

            // Bottom row
            for (int j = right; j >= left; j--) {
                grid[bottom][j] = nums.get(idx++);
            }

            // Left column
            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = nums.get(idx++);
            }
        }
        return grid;
    }
}