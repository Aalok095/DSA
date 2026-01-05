class Solution {
    public long maxMatrixSum(int[][] mat) {
        int n = mat.length,min = Integer.MAX_VALUE,x = 0;
        long s = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]<0) x++;
                int val = Math.abs(mat[i][j]);
                min = Math.min(min,val);
                s += val;
            }
        }
        System.out.print(min);
        if(x%2!=0) return s-(min*2);
        return s;
    }
}