class Solution {
    public boolean helper(long mid, int mh, int[] wt){
        long h = 0;
        for(int t : wt){
            h += (long)(Math.sqrt(2.0 * mid / t + 0.25) - 0.5);
            if(h >= mh) return true;
        }
        return false;
    }

    public long minNumberOfSeconds(int mh, int[] wt) {
        long maxT = Arrays.stream(wt).max().getAsInt();

        long l = 1;
        long r = maxT * (long)mh * (mh + 1) / 2;

        long res = 0;
        while(l <= r){
            long mid = l + (r - l) / 2;
            if(helper(mid,mh,wt)){
                res = mid;
                r = mid - 1;
            } 
            else l = mid + 1;
        }
        return res;
    }
}