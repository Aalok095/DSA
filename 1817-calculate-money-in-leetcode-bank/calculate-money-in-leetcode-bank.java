class Solution {
    public int totalMoney(int n) {
        int c = 1;
        int ans = 0;
        int k = 1;
        int m = 1;
        for(int i=0;i<n;i++){
            if(k!=8) ans+=c;
            if(k==8){
                k=1;
                m++;
                c=m;
                ans+=m;
            }
            c++;
            k++;
        }
        return ans;
    }
}