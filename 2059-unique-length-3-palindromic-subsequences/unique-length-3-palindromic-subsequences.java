class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        for(char ch = 'a'; ch<='z'; ch++){

            int l = s.indexOf(ch),r = s.lastIndexOf(ch);
            if(l==r || l==-1) continue;
            
            Set<Character> set = new HashSet<>();
            for(int i=l+1;i<r;i++){
                set.add(s.charAt(i));
            }
            ans+=set.size();
        }
        return ans;
    }
}
