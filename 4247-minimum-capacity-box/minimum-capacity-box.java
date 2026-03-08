class Solution {
    public int minimumIndex(int[] cap, int it) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0;i < cap.length;i++) {
            if (cap[i] >= it && cap[i] < min) {
                min = cap[i];
                idx = i;
            }
        }
        return idx;
    }
}