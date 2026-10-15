
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int c = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                c += set.size() * set.size();
            }
        }

        return c;
    }
}
