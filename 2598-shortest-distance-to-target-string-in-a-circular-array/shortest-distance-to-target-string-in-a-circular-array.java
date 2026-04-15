class Solution {
    public int closestTarget(String[] w, String t, int s) {
        int ans = Integer.MAX_VALUE;
        int n = w.length;
        int a = 0, b = 0;
        int i = s, j = s;
        int c1 = 0, c2 = 0;
        while (a < n) { // right
            if (w[(i + n) % n].equals(t)) break;
            a++;
            c1++;
            i++;
        }
        while (b < n) { // left
            if (w[(j + n) % n].equals(t)) break;
            b++;
            c2++;
            j--;
        }

        return (c1 == n) ? -1 : Math.min(c1, c2);
    }
}