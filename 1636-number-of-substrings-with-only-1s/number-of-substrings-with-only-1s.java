class Solution {
    static final int M = 1_000_000_007;
    
    public int numSub(String s) {
        long ans = 0;
        long count1 = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
                ans = (ans + count1) % M; // add current streak
            } else count1 = 0;
        }

        return (int) ans;
    }
}