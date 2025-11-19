class Solution {
    public int findFinalValue(int[] nums, int o) {
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        while(set.contains(o)) o*=2;
        return o;
    }
}