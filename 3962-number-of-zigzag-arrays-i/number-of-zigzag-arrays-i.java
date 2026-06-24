class Solution {
    int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Length = 2
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        long[] pref = new long[m + 1];
        long[] suff = new long[m + 2];
        long[] newUp = new long[m + 1];
        long[] newDown = new long[m + 1];

        for (int len = 3; len <= n; len++) {

            pref[0] = 0;
            for (int i = 1; i <= m; i++) {
                pref[i] = (pref[i - 1] + down[i]) % MOD;
            }

            suff[m + 1] = 0;
            for (int i = m; i >= 1; i--) {
                suff[i] = (suff[i + 1] + up[i]) % MOD;
            }

            for (int x = 1; x <= m; x++) {
                newUp[x] = pref[x - 1];
                newDown[x] = suff[x + 1];
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}