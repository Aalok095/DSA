class Solution {
    public boolean check(long mid,long[] diff,int r,int k,int n){
        long[] tempDiff = Arrays.copyOf(diff,n);
        long cumSum = 0;

        for(int i=0;i<n;i++){
            cumSum+=tempDiff[i];
            if(cumSum<mid){
                long need = mid - cumSum;
                if(need>k) return false;
                k-=need;
                cumSum+=need;
                if(i+2L*r+1<n) tempDiff[(int)(i+2L*r+1)] -= need;
            }
        }
        return true;
    }
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diff = new long[n];
        // diff arr tech hulabu hu hu ....
        for(int i=0;i<n;i++){
            int left = Math.max(0,i-r);
            int right = i+r+1;
            diff[left] += stations[i];
            if (right<n) diff[right] -= stations[i];
        }
        long lo = Arrays.stream(stations).min().getAsInt();//min
        long hi = Arrays.stream(stations).asLongStream().sum() + k;//max
        long res = 0;
        while(lo<=hi){
            long mid = lo+(hi-lo)/2;
            if(check(mid,diff,r,k,n)){
                res = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return res;
    }
}