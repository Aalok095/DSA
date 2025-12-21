class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;          // number of rows
        int cols = strs[0].length();     // number of columns

        int d = 0;
        boolean[] sorted = new boolean[rows];
        for (int col = 0;col < cols;col++) {
            boolean del = false;
            for (int row = 0;row < rows - 1;row++) {
                if (!sorted[row] && strs[row].charAt(col) > strs[row+1].charAt(col)) {
                    d++;
                    del = true;
                    break;
                }
            }
            if (del) continue;
            for (int i = 0; i < rows - 1; i++) {
                sorted[i] = sorted[i] || (strs[i].charAt(col) < strs[i+1].charAt(col));
            }
        }
        return d;
    }
}