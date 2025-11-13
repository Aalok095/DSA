class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int ones = 0,ans = 0;
        for (int i = 0;i < n;i++) {
            if (s.charAt(i)=='1') ones++;
            else if (i > 0 && s.charAt(i - 1)=='1') ans += ones;
        }
        return ans;
    }
}