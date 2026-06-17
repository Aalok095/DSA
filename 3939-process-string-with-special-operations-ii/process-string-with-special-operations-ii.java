class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long L = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (L > 0) L--;
            } else if (ch == '#') {
                L *= 2;
            } else if (ch == '%') {
                // reverse - no change in L
                continue;
            } else { // 'a' to 'z'
                L++;
            }
        }

        if (k >= L) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') {
                L++; // no change in k
            } else if (ch == '%') {
                // no change in L
                k = L - k - 1;
            } else if (ch == '#') {
                L = L / 2;
                k = (k >= L) ? k - L : k;
            } else { // 'a' to 'z'
                L--;
            }

            if (k == L) return ch;
            
        }
        return '.';
    }
}