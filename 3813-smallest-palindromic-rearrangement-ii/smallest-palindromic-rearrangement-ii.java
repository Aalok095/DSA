class Solution {
    long comb(int n, int r, int lim) {
        r = Math.min(r, n - r);
        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans > lim) return lim + 1L;
        }

        return ans;
    }

    long calc(int[] cnt, int rem, int lim) {
        long ans = 1;

        for (int x : cnt) {
            if (x == 0) continue;

            ans *= comb(rem, x, lim);
            if (ans > lim) return lim + 1L;

            rem -= x;
        }

        return ans;
    }

    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];

        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        int n = s.length(), m = n / 2;
        char[] ans = new char[n];

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1)
                ans[m] = (char) ('a' + i);

            cnt[i] /= 2;
        }

        if (calc(cnt, m, k) < k)
            return "";

        for (int i = 0; i < m; i++) {
            for (int c = 0; c < 26; c++) {
                if (cnt[c] == 0) continue;

                cnt[c]--;
                long cur = calc(cnt, m - i - 1, k);

                if (cur >= k) {
                    ans[i] = (char) ('a' + c);
                    break;
                }

                k -= cur;
                cnt[c]++;
            }
        }

        for (int i = 0; i < m; i++)
            ans[n - 1 - i] = ans[i];

        return new String(ans);
    }
}