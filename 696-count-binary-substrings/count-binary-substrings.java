class Solution {
    public int countBinarySubstrings(String s) {
        int i = 1,c = 0,n = s.length();
        int curr = 1,prev = 0;
        while(i<n){
            if(s.charAt(i)==s.charAt(i-1)) curr++;
            else {
                c += Math.min(curr,prev);
                prev = curr;
                curr = 1;
            }
            i++;
        }
        return c+Math.min(prev,curr);
    }
}