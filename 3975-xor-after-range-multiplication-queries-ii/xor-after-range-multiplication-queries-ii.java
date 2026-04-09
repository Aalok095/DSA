class Solution {
    int M = (int)1e9 + 7;
    // Iterative Binary Exponentiation (FLT)
    long power(long a, long b) { 
        long result = 1;
        a = a % M;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % M;
            }
            a = (a * a) % M;
            b >>= 1;
        }
        return result;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int blockSize = (int)Math.ceil(Math.sqrt(n));

        // Map: k -> list of queries
        Map<Integer, List<int[]>> smallKMap = new HashMap<>();

        // Step 1 ->  Process large K directly
        for (int[] query : queries) {
            int L = query[0];
            int R = query[1];
            int K = query[2];
            int V = query[3];

            if (K >= blockSize) {
                for (int i = L; i <= R; i += K) {
                    nums[i] = (int)((1L * nums[i] * V) % M);
                }
            } else {
                smallKMap.computeIfAbsent(K, k -> new ArrayList<>()).add(query);
            }
        }

        // Step 2-> Process small K using diff array
        for (Map.Entry<Integer, List<int[]>> entry : smallKMap.entrySet()) {
            int K = entry.getKey();
            List<int[]> allQueries = entry.getValue();

            long[] diff = new long[n];
            Arrays.fill(diff, 1);

            // Apply all queries of this K
            for (int[] query : allQueries) {
                int L = query[0];
                int R = query[1];
                int V = query[3];

                diff[L] = (diff[L] * V) % M;

                int steps = (R - L) / K;
                int next = L + (steps + 1) * K;

                if (next < n) {
                    diff[next] = (diff[next] * power(V, M - 2)) % M;
                }
            }

            // Propagation (jump by K)
            for (int i = 0; i < n; i++) {
                if (i - K >= 0) {
                    diff[i] = (diff[i] * diff[i - K]) % M;
                }
            }

            // Apply to nums
            for (int i = 0; i < n; i++) {
                nums[i] = (int)((1L * nums[i] * diff[i]) % M);
            }
        }
        int result = 0;
        for (int num : nums) result ^= num;
        
        return result;
    }
}