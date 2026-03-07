class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            s1.append((i % 2 == 0) ? '0' : '1');
            s2.append((i % 2 == 0) ? '1' : '0');
        }

        int min = Integer.MAX_VALUE;
        int flip1 = 0,flip2 = 0;
        int i = 0,j = 0;

        while (j < 2 * n) {

            if (s.charAt(j) != s1.charAt(j)) flip1++;
            if (s.charAt(j) != s2.charAt(j)) flip2++;

            if (j - i + 1 > n) {
                if (s.charAt(i) != s1.charAt(i)) flip1--;
                if (s.charAt(i) != s2.charAt(i)) flip2--;
                i++;
            }

            if (j - i + 1 == n) min = Math.min(min, Math.min(flip1, flip2));
            j++;
        }
        return min;
    }
}