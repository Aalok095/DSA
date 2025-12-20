class Solution {
    public int minDeletionSize(String[] s) {
        int n = s[0].length();
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=1;j<s.length;j++){
                if(s[j].charAt(i) < s[j-1].charAt(i)) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }
}