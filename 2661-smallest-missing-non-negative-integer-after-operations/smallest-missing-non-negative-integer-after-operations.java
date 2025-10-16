class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums) {
            int r = ((ele % value) + value) % value;// for negative mf (non -ve integer remainder)
            map.put(r,map.getOrDefault(r,0)+1);
        }
        int MEX = 0;
        // increment mex while we have available remainders
        while(map.getOrDefault(MEX % value,0) > 0){
            map.put(MEX % value,map.get(MEX % value) - 1);
            MEX++;
        }
        return MEX;
    }
}