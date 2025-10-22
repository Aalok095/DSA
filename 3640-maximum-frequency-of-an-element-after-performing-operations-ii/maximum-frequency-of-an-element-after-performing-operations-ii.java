class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k;
        TreeMap<Integer,Integer> diff = new TreeMap<>();// sorted freq
        HashMap<Integer,Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);

            int l = Math.max(num-k, 0);
            int r = Math.min(num+k,maxVal);

            diff.put(l,diff.getOrDefault(l,0)+1);
            diff.put(r+1,diff.getOrDefault(r+1,0)-1);

            diff.putIfAbsent(num,diff.getOrDefault(num,0));
        }

        int res = 1;
        int cumSum = 0;

        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int target = entry.getKey();
            int val = entry.getValue();

            cumSum += val;
            int targetFreq = freq.getOrDefault(target,0);
            int needConversion = cumSum-targetFreq;

            int maxPossibleFreq = Math.min(needConversion,numOperations);
            res = Math.max(res,targetFreq + maxPossibleFreq);
        }
        return res;
    }
}