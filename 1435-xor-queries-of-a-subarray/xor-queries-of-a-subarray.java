class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        for(int i=1;i<n;i++){ // prefix xor
            arr[i] ^= arr[i-1];
        }
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            int l = queries[i][0],r = queries[i][1];
            if(l==0) ans[i] = arr[r];
            else ans[i] = arr[l-1] ^ arr[r];
        }
        return ans;
    }
}