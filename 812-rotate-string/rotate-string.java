class Solution {
    public boolean rotateString(String s, String g) {
        if(s.length()!=g.length()) return false;
        String x = s+s;
        return x.indexOf(g)!=-1;
    }
}