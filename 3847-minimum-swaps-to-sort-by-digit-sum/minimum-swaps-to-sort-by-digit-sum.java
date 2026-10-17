class Solution {

    private int digitSum(int n) {
        int s = 0;

        while (n > 0) {
            s += n % 10;
            n /= 10;
        }

        return s;
    }

    private int cmp(int a, int b) {
        int s1 = digitSum(a);
        int s2 = digitSum(b);

        if (s1 != s2) {
            return Integer.compare(s1, s2);
        }

        return Integer.compare(a, b);
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted, this::cmp);

        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(nums[i], i);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int exp = sorted[i];
            int cur = nums[i];

            if (exp == cur) continue;

            int j = idx.get(exp);

            nums[i] = exp;
            nums[j] = cur;

            idx.put(exp, i);
            idx.put(cur, j);

            swaps++;
        }

        return swaps;
    }
}