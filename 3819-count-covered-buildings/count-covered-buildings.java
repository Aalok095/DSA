class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,int[]> ytoMinMaxX = new HashMap<>();
        HashMap<Integer,int[]> xtoMinMaxY = new HashMap<>();
        for(int[] b : buildings){
            int x = b[0];
            int y = b[1];
            ytoMinMaxX.putIfAbsent(y,new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            xtoMinMaxY.putIfAbsent(x,new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});

            int[] xr = ytoMinMaxX.get(y);
            xr[0] = Math.min(xr[0],x);
            xr[1] = Math.max(xr[1],x);

            int[] yr = xtoMinMaxY.get(x);
            yr[0] = Math.min(yr[0],y);
            yr[1] = Math.max(yr[1],y); 
        }
        int ans = 0;
        for(int[] b : buildings){
            int x = b[0];
            int y = b[1];
            int[] xr = ytoMinMaxX.get(y);
            int[] yr = xtoMinMaxY.get(x);
            if(xr[0] < x && x < xr[1] && yr[0] < y && y < yr[1]) ans++;
        }
        return ans; 
    }
}