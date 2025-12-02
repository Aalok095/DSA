class Solution {
    static final int M = 1000000007;

    public int countTrapezoids(int[][] points) {
        // Map y -> count of points having that y-coordinate
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            map.put(y,map.getOrDefault(y, 0) + 1);
        }

        long res = 0;
        long phl = 0;// phl -> prev_Horizontal_Lines

        for (int count : map.values()) {
            long hl = (long) count*(count-1)/2; // C(n, 2)// hl -> horizontal_Lines
            res = (res + hl * phl) % M;
            phl += hl;
        }
        return (int)(res % M);
    }
}