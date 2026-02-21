class Solution {
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=n-1;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int countPrimeSetBits(int l, int r) {
        int x = 0;
        for(int i=l;i<=r;i++){
            int c = Integer.bitCount(i);
            if(isPrime(c)) x++;
        }
        return x;
    }
}