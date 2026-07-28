class Solution {
    public String smallestPalindrome(String s) {
        int[] f = new int[26];
        for(char ch : s.toCharArray()) f[ch-'a']++;
        int n = s.length();
        char[] ans = new char[n];
        int l=0,r=n-1;
        for(int i=0;i<26;i++){
            while(f[i]>=2){
                ans[l++] = (char)('a'+i);
                ans[r--] = (char)('a'+i);
                f[i]-=2;
            }
            if(f[i]==1) ans[n/2] = (char)('a'+i);
        }
        return new String(ans);
    }
}