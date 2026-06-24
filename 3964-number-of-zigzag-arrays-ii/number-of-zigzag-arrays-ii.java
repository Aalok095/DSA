class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        int size = m << 1;

        long[][] trans = new long[size][size];

        for (int x = 0; x < m; x++) {
            long[] row = trans[x];
            for (int y = x + 1; y < m; y++) {
                row[m + y] = 1;
            }
        }

        for (int x = 0; x < m; x++) {
            long[] row = trans[m + x];
            for (int y = 0; y < x; y++) {
                row[y] = 1;
            }
        }

        long[] vec = new long[size];

        for (int i = 0; i < m; i++) {
            vec[i] = 1;
        }

        long exp = n - 1;
        long[][] base = trans;

        while (exp > 0) {
            if ((exp & 1L) != 0) {
                vec = multiplyMatVec(base, vec);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        long ans = 0;

        for (long x : vec) {
            ans += x;
            if (ans >= MOD) ans -= MOD;
        }

        ans = (ans * 2) % MOD;

        return (int) ans;
    }

    private long[] multiplyMatVec(long[][] mat, long[] vec) {
        int n = mat.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long[] row = mat[i];

            long sum = 0;

            for (int j = 0; j < n; j++) {
                long v = row[j];
                if (v == 0) continue;

                sum += v * vec[j];

                if (sum >= (1L << 60)) {
                    sum %= MOD;
                }
            }

            res[i] = sum % MOD;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            long[] ai = a[i];
            long[] ri = res[i];

            for (int k = 0; k < n; k++) {
                long aik = ai[k];

                if (aik == 0) continue;

                long[] bk = b[k];

                for (int j = 0; j < n; j++) {
                    long bkj = bk[j];

                    if (bkj == 0) continue;

                    ri[j] += aik * bkj;

                    if (ri[j] >= (1L << 60)) {
                        ri[j] %= MOD;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                ri[j] %= MOD;
            }
        }
        return res;
    }
}