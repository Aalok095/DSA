class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int maxSide = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                // width
                int x2 = Math.min(topRight[i][0],topRight[j][0]);// upper
                int x1 = Math.max(bottomLeft[i][0],bottomLeft[j][0]);// lower 
                int width = x2-x1;
                // height
                int y2 = Math.min(topRight[i][1],topRight[j][1]); // uperr
                int y1 = Math.max(bottomLeft[i][1],bottomLeft[j][1]);// lower 
                int height = y2-y1;
                int side = Math.min(height,width);
                maxSide = Math.max(maxSide,side);
            }
        }
        return 1L*maxSide*maxSide;
    }
}