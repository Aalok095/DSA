class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length,n = grid[0].length,c=0;
        for(int i=0;i<m;i++){
            int lo = 0,hi = n-1;
                while(lo<=hi){
                    int mid = lo+(hi-lo)/2;
                    if(grid[i][mid]<0) hi = mid-1;
                    else lo = mid+1;              
                }
                c += n-lo;
        }
        return c;
    }
}