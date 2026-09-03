class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        int oddCnt = 0;
        for (int x : nums1) {
            min = Math.min(min, x);
            if (x % 2 == 1) oddCnt++;
        }
        // min Element is ODD(remaining even > min) or All Even!
        return min % 2 != 0 || oddCnt == 0;
    }
}