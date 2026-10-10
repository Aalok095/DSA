class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int[] diff = new int[n];
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // freq[d] = count of indices with diff exactly d
        int[] freq = new int[maxDiff + 1];
        for (int d : diff) {
            freq[d]++;
        }

        long K = (long) k1 + k2;

        for (int i = maxDiff; i > 0 && K > 0; i--) {
            int countOps = (int) Math.min(freq[i],K);
            freq[i] -= countOps;
            freq[i - 1] += countOps;
            K -= countOps;
        }

        long sum = 0;
        for (long d = 1; d <= maxDiff; d++) {
            sum += freq[(int)d] * d * d;
        }

        return sum;
    }
}