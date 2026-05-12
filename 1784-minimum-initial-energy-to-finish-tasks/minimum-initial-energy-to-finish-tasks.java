class Solution {
    public boolean isPossible(int[][] task,int mid){
        for(int[] t : task){
            int act = t[0],min = t[1];
            if(min>mid) return false;
            mid -= act;
        }
        return true;
    }

    public int minimumEffort(int[][] task) {
        Arrays.sort(task, (a,b)->{
            return (b[1]-b[0])-(a[1]-a[0]);
        });

        int lo = 0, hi = (int)1e9;
        int res = Integer.MAX_VALUE;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isPossible(task,mid)){
                res = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return res;
    }
}