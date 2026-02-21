class Solution {
    public int countPrimeSetBits(int l, int r) {
        boolean[] prime = new boolean[33];
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
        for(int p : primes) prime[p] = true;

        int c = 0;
        for(int i = l;i <= r;i++) if(prime[Integer.bitCount(i)]) c++;
        return c;
    }
}