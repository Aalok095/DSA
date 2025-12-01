class Solution {
    public boolean possible(int[] b,long mid,int n){
        long target = n*mid;
        for(int ele : b){
            target -= Math.min(mid,ele);
            if(target<=0) return true;
        }
        return false;
    }
    public long maxRunTime(int n, int[] b) {

        long min = Integer.MAX_VALUE,s = 0;
        for(int ele : b){
            min = Math.min(min,ele);
            s+=ele;
        }
        long res = 0;
        long l = min;
        long r = s/n;

        while(l<=r){
            long mid = l+(r-l)/2;
            if(possible(b,mid,n)) {
                res = mid;
                l = mid+1;
            }
            else r = mid-1;
        }

        return  res;
    }
}