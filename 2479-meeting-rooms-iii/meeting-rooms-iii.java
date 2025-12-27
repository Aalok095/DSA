class Solution {
    public int mostBooked(int n, int[][] m) {
        Arrays.sort(m, (a, b) -> Integer.compare(a[0], b[0]));
        int[] c = new int[n]; // room usage count

        // used rooms -> {endTime,room}
        PriorityQueue<long[]> used = new PriorityQueue<>((a,b) -> a[0]!=b[0]
                ? Long.compare(a[0],b[0])
                : Long.compare(a[1],b[1])
        );

        // unused rooms (smallest index first)
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0;i < n;i++) free.add(i);

        for (int[] meet : m) {
            long s = meet[0];
            long e = meet[1];

            // free rooms that ended before current meeting
            while (!used.isEmpty() && used.peek()[0] <= s) {
                free.add((int) used.poll()[1]);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                used.add(new long[]{e,room});
                c[room]++;
            } else {
                long[] top = used.poll();
                long newEnd = top[0] + (e - s);
                used.add(new long[]{newEnd, top[1]});
                c[(int)top[1]]++;
            }
        }
        int res = 0;
        for (int i = 0;i < n;i++) if (c[i] > c[res]) res = i;
        return res;
    }
}