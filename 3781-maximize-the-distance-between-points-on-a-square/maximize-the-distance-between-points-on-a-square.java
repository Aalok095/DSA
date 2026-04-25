class Solution {

    long get1D(int side, int x, int y) {
        if (y == 0) return x;
        if (x == side) return (long) side + y;
        if (y == side) return 3L * side - x;
        return 4L * side - y;
    }

    boolean check(long[] doubled, int n, int k, int side, int mid) {
        long perimeter = 4L * side;

        for (int i = 0; i < n; i++) {   // O(n)
            int count = 1;
            int idx = i;

            long lastPos = doubled[idx];

            for (int j = 2; j <= k; j++) {   // O(k log n)
                long target = lastPos + mid;

                int nextIdx = lowerBound(doubled, idx + 1, i + n, target);

                if (nextIdx == i + n) break;

                idx = nextIdx;
                lastPos = doubled[idx];
                count++;
            }

            if (count == k && (doubled[i] + perimeter - lastPos >= mid)) {
                return true;
            }
        }
        return false;
    }

    // Custom lower_bound (first index >= target)
    int lowerBound(long[] arr, int left, int right, long target) {
        int ans = right;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long perimeter = 4L * side;

        long[] positions = new long[n];

        for (int i = 0; i < n; i++) {
            positions[i] = get1D(side, points[i][0], points[i][1]);
        }
        Arrays.sort(positions);

        // double array
        long[] doubled = new long[2 * n];
        for (int i = 0; i < n; i++) {
            doubled[i] = positions[i];
            doubled[i + n] = positions[i] + perimeter;
        }

        int left = 0, right = 2 * side;
        int result = 0;

        while (left <= right) {   // O(log side)
            int mid = left + (right - left) / 2;
            if (check(doubled, n, k, side, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}