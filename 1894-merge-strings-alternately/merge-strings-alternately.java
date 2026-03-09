class Solution {
    public String mergeAlternately(String w1, String w2) {
        StringBuilder sb = new StringBuilder();
        int n = w1.length(),m = w2.length();
        int i = 0, j=0;
        while(i<n && j<m){
            sb.append(w1.charAt(i++));
            sb.append(w2.charAt(j++));
        }
        while(i<n) sb.append(w1.charAt(i++));
        while(j<m) sb.append(w2.charAt(j++));
        return sb.toString();
    }
}