class Solution {
    public int xorOperation(int n, int st) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = st+2*i;
        } 
        int x = 0;
        for(int ele : arr) x ^= ele;
        return x;
    }
}