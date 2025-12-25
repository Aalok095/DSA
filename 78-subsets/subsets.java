class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int total = (1<<n);
        for(int num = 0; num < total; num++){
            List<Integer> list = new ArrayList<>();
            for(int bitIdx = 0; bitIdx < n; bitIdx++){
                int mask = (1<<bitIdx);
                if((num&mask)!=0) list.add(nums[bitIdx]);
            }
            ans.add(list);
        }
        return ans;
    }
}