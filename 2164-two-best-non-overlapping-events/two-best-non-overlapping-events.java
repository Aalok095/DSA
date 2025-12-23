class Solution {
    public int bs(int[][] events,int end){
        int n = events.length;
        int res = n;
        int lo = 0,hi = n-1;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(events[mid][0]>end){
                res = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return res;
    }

    public int solve(int[][] events,int i,int count,int[][] dp){
        if(count==2 || i>=events.length) return 0;

        if(dp[i][count]!=-1) return dp[i][count];

        int nextIdx = bs(events,events[i][1]);

        int take = events[i][2] + solve(events,nextIdx,count+1,dp);
        int skip = solve(events,i+1,count,dp);

        return dp[i][count] = Math.max(take,skip);
    }

    public int maxTwoEvents(int[][] events){
        int n = events.length;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(events,0,0,dp);
    }
}