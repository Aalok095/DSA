class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        double x = Math.pow(2,k);
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<=n-k;i++) set.add(s.substring(i,i+k));
        return (int)x == set.size();
    }
}