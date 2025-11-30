class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int s = 0;
        for(int ele : nums) s = (s+ele)%p;
        int target = s%p;
        if(target==0) return 0;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); //-> sum,index

        int curr = 0;
        int res = n;
        for(int j=0;j<n;j++){
            curr = (curr+nums[j])%p;
            int remain = (curr - target + p)%p;
            if(map.containsKey(remain)) res = Math.min(res,j-map.get(remain));
            map.put(curr,j);
        }
        return res == n ? -1 : res;
    }
}