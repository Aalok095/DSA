class Solution {
    private int cost(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int len = arr[j+1] - arr[i-1];
            int totalCost = cost(i,k-1,arr,dp)+cost(k+1,j,arr,dp)+len;
            min = Math.min(min,totalCost);
        }
        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length+2];
        int i;
        for(i=0;i<cuts.length;i++){
            arr[i] = cuts[i]; 
        }
        arr[i++] = 0;
        arr[i] = n;
        Arrays.sort(arr);
        int m = arr.length;
        // i-> 1 to m-2 || j -> m-2 to 1;
        int[][] dp = new int[m-1][m-1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return cost(1,arr.length-2,arr,dp);// mcm
    }
}