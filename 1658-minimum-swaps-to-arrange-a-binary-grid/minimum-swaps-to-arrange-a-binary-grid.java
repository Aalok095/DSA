class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] end = new int[n];

        for(int i=0;i<n;i++){
            int c = 0,j=n-1;
            while(j>=0 && grid[i][j]==0){
                c++;
                j--;
            }
            end[i] = c;
        }

        int swaps = 0;

        for(int i=0;i<n;i++){

            int need = n-i-1;
            int j = i;

            while (j<n && end[j]<need) j++;
            if(j==n) return -1;
            
            swaps += j-i;
            while(j>i){// reflecting the swaps
                int temp = end[j];
                end[j] = end[j-1];
                end[j-1] = temp;
                j--;
            }
        }
        return swaps;
    }
}