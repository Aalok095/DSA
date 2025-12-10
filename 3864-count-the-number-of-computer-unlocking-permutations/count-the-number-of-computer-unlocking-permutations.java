class Solution {
    public int countPermutations(int[] c) {// c-> complexity
        int n = c.length;
        long res = 1;
        for(int i=1;i<n;i++){
            if(c[i]<=c[0]) return 0;
            res = (res*i) % 1000000007;
        }
        return (int)res;
    }
}