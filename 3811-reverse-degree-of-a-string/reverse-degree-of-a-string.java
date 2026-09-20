class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=1;i<=n;i++){
            char ch = s.charAt(i-1);
            ans += ((123-(int)ch)*i); 
        }
        return ans;
    }
}