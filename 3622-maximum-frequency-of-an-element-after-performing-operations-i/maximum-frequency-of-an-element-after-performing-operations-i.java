class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt()+k;

        int[] diff = new int[maxVal+2];

        HashMap<Integer,Integer> map = new HashMap<>();
        // difference array technique N!GG@
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);

            int l = Math.max(0,ele-k);
            int r = Math.min(maxVal,ele+k);

            diff[l]++;
            diff[r+1]--;
        }
        int res = 1;
        for(int target=0;target<=maxVal;target++){
            if(target>0) diff[target] += diff[target-1];

            int targetFreq = map.getOrDefault(target,0);
            int needConversion = diff[target]-targetFreq;

            int maxPossFreq = Math.min(needConversion,numOperations);
            res = Math.max(res,targetFreq + maxPossFreq);
        }
        return res;
    }
}