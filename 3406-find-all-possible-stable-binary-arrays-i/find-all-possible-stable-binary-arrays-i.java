class Solution {
    int M = 1_000_000_007;
    int[][][] t = new int[201][201][2]; // 1s, 0s ,either t/f

    int solve(int onesLeft, int zerosLeft, int lastWasOne, int limit) {
        if (onesLeft == 0 && zerosLeft == 0) return 1; // base
        if (t[onesLeft][zerosLeft][lastWasOne] != -1) return t[onesLeft][zerosLeft][lastWasOne];

        int result = 0;
        if (lastWasOne == 1) { // explore 0s
            for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                result = (result + solve(onesLeft, zerosLeft - len, 0, limit)) % M;
            }
        } else { // explore 1s
            for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                result = (result + solve(onesLeft - len, zerosLeft, 1, limit)) % M;
            }
        }
        return t[onesLeft][zerosLeft][lastWasOne] = result;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        for (int[][] a : t) for (int[] b : a) Arrays.fill(b,-1);
        int startWithOne  = solve(one,zero,0,limit);
        int startWithZero = solve(one,zero,1,limit);
        return (startWithOne + startWithZero) % M;
    }
}