class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) map.computeIfAbsent(nums[i],l -> new ArrayList<>()).add(i);
        List<Integer> ans = new ArrayList<>();
        for(int q : queries){
            List<Integer> temp = map.get(nums[q]);

            if(temp.size()==1){
                ans.add(-1);
                continue;
            }
            
            int pos = Collections.binarySearch(temp,q);
            int min = Integer.MAX_VALUE;
            
            int left = temp.get((pos - 1 + temp.size()) % temp.size());// left
            int d1 = Math.abs(q - left);
            min = Math.min(min, Math.min(d1, n-d1));

            int right = temp.get((pos + 1) % temp.size());// right
            int d2 = Math.abs(q - right);
            min = Math.min(min, Math.min(d2, n-d2));

            ans.add(min);
        }
        return ans;
    }
}