class Solution {
    public int minNumberOperations(int[] t) {
        int n = t.length;
        int op = 0;
        int prev = 0;
        for(int i=0;i<n;i++){
            int curr = t[i];
            if(curr>prev){
                op += (curr-prev);
            }
            prev = curr;
        }
        return op;
    }
}