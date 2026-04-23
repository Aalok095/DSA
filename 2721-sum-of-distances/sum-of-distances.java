class Solution {
    public long[] distance(int[] nums) {
        int  n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> list : map.values()){
            int m = list.size();

            long[] pre = new long[m];
            pre[0] = list.get(0);

            for(int i=1;i<m;i++){
                pre[i] = pre[i-1]+list.get(i);
            }
            
            for(int i=0;i<m;i++){
                int idx = list.get(i);
                long left = (long) list.get(i)*i-(i>0 ? pre[i-1] : 0);
                long right = (pre[m-1] - pre[i]) - (long) list.get(i)*(m-i-1);
                ans[idx] = left + right;
            } 
        }
        return ans;
    }
}