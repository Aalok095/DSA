class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int ele : nums){
            int s = ele+1;
            int n = 2;
            for(int i=2;i*i<=ele;i++){
                if(ele%i==0){
                    int d = ele/i;
                    if(i==d){
                        n++;
                        s += i;
                    }
                    else {
                        n += 2;
                        s += d+i;
                    }
                }
            }
            if(n==4) ans += s;
        }
        return ans;
    }
}