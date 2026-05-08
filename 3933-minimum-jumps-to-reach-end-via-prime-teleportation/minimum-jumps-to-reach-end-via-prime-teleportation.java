class Solution {

    static final int MAX = 1000000;
    static boolean[] prime = sieve();

    public int minJumps(int[] nums) {

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build prime factor -> indices map
        for (int i = 0; i < n; i++) {

            int x = nums[i];

            for (int p : getPrimeFactors(x)) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) return steps;

                // adjacent left
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                // adjacent right
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                // teleportation
                int val = nums[i];

                if (prime[val]) {

                    List<Integer> next = map.get(val);

                    if (next != null) {

                        for (int idx : next) {

                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.offer(idx);
                            }
                        }
                        map.remove(val);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    static boolean[] sieve() {

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    
    List<Integer> getPrimeFactors(int x) {

        List<Integer> res = new ArrayList<>();

        for (int p = 2; p * p <= x; p++) {

            if (x % p == 0) {

                res.add(p);

                while (x % p == 0) {
                    x /= p;
                }
            }
        }
        if (x > 1) res.add(x);
        return res;
    }
}