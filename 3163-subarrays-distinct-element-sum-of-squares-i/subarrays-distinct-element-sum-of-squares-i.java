class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[101];
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int num = nums.get(j);
                if (freq[num] == 0) distinct++;
                freq[num]++;
                ans += distinct * distinct;
            }
        }
        return ans;
    }
}

