class Solution {
    public boolean isPrime(int x){
        if(x<2) return false;
        for(int i=2;i*i<=x;i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int ele : nums){
            int p = (int)Math.round(Math.cbrt(ele)); // ele = p^3
            if((long)p*p*p==ele && isPrime(p)) {
                ans += 1+p+p*p+ele;
                continue;
            }
            
            for(int i=2;i*i<=ele;i++){// ele = p * q;
                if(ele%i==0){
                    int q = ele/i;
                    if(i!=q && isPrime(i) && isPrime(q)) ans += 1+i+q+ele; 
                    break;
                }
            }    
        }
        return ans;
    }
}