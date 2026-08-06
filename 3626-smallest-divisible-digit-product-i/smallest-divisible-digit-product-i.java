class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=120;i++){
            int a = i;
            int p = 1;
            while(a!=0){
                p*=(a%10);
                a/=10;
            }
            if(p%t==0) return i;
        }
        return 69;
    }
}