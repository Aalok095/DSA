class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] freq = new int[51];
        int c = 0;
        for(int i=0;i<n;i++){
            freq[A[i]]++;
            if(freq[A[i]]==0) c++;
            freq[B[i]]--;
            if(freq[B[i]]==0) c++;
            ans[i] = c;
        }
        return ans;
    }
}