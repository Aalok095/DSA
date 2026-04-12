class Solution {
    int[][][][][] dp = new int[301][7][7][7][7];

    public int[] getCoordinate(char ch) {
        int pos = ch - 'A';
        return new int[]{pos/6, pos%6}; // 6 is no. of col to get cordinates
    }

    public int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int solve(String word, int i, int x1, int y1, int x2, int y2) {
        if (i == word.length()) return 0;

        if (dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] != -1) return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1];

        int[] coord = getCoordinate(word.charAt(i));
        int x = coord[0], y = coord[1];

        // Case 1: first finger not used
        if (x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1) {
            //using finger 1
            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] =
                    solve(word, i + 1, x, y, x2, y2); //Choose any finger (1 or 2), both symmetric
        }

        // Case 2: second finger not used
        if (x2 == -1 && y2 == -1) {
            int moveF2 = solve(word, i + 1, x1, y1, x, y);

            int moveF1 = solve(word, i + 1, x, y, x2, y2)
                    + getDistance(x1, y1, x, y);

            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] =
                    Math.min(moveF1, moveF2);
        }

        // Case 3: both fingers used
        int moveF1 = solve(word, i + 1, x, y, x2, y2)+ getDistance(x1, y1, x, y);
        int moveF2 = solve(word, i + 1, x1, y1, x, y) + getDistance(x2, y2, x, y);
        return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] = Math.min(moveF1, moveF2);
    }

    public int minimumDistance(String word) {
        //finger1 = (x1, y1)
        //finger2 = (x2, y2)
        for (int i = 0; i < 301; i++)
            for (int a = 0; a < 7; a++)
                for (int b = 0; b < 7; b++)
                    for (int c = 0; c < 7; c++)
                        Arrays.fill(dp[i][a][b][c], -1);

        return solve(word, 0, -1, -1, -1, -1);
    }
}
