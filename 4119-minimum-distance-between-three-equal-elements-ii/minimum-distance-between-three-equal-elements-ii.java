class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],a -> new ArrayList<>()).add(i);
        }
        int min = Integer.MAX_VALUE;
        for(List<Integer> list : map.values()){
            if(list.size()>=3){ // ∣i−j∣+ ∣j−k∣ + ∣k−i∣ = 2∗(max(i,j,k)−min(i,j,k)),
                for (int i = 0;i+2<list.size();i++) {
                    int first = list.get(i);
                    int third = list.get(i+2);
                    min = Math.min(min,2*(third-first));
                }
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
}