class Solution {
    public int[] validSequence(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int[] rmatch = new int[n + 1];

        int i = n - 1;
        int j = m - 1;
        int c = 0;

        // Build suffix matching information
        while (i >= 0) {
            if (j >= 0 && w1.charAt(i) == w2.charAt(j)) {
                c++;
                j--;
            }
            rmatch[i] = c;
            i--;
        }

        int[] ans = new int[m];
        i = 0;
        j = 0;
        int k = 0;

        boolean flag = true;
        while (i < n && j < m) {
            if (w1.charAt(i) == w2.charAt(j) || (flag && rmatch[i + 1] >= m - j - 1)) {
                ans[k++] = i;
                if (w1.charAt(i) != w2.charAt(j)) flag = false;
                j++;
            }
            i++;
        }

        return j == m ? ans : new int[0];
    }
}