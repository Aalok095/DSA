class Solution {
    public int minBitFlips(int st, int gl) {
        int n = st^gl; // xor kar ke number of set bits nikal do simple
        int c = 0;
        for(int i=0;i<=31;i++){
            int mask = 1<<i;
            if((n & mask)!=0) c++;
        }
        return c;
    }
}