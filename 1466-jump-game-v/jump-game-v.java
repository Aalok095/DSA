class Solution {
    int n;
    int[] t;

    private int solve(int[] arr, int d, int i) {
        if (t[i] != -1) return t[i];

        int result = 1; // count current index also

        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            // can't jump further once taller/equal element appears
            if (arr[j] >= arr[i]) break;
            result = Math.max(result, 1 + solve(arr, d, j));
        }

        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            // can't jump further once taller/equal element appears
            if (arr[j] >= arr[i]) break;
            result = Math.max(result, 1 + solve(arr, d, j));
        }
        return t[i] = result;
    }

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        t = new int[n];
        Arrays.fill(t, -1);

        int maxJump = 1;
        // We need to try from every index
        for (int i = 0; i < n; i++) {
            maxJump = Math.max(maxJump, solve(arr, d, i));
        }
        return maxJump;
    }
}