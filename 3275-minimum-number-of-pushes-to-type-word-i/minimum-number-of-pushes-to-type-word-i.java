class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int c = 0;
        for(int i = 0;i < n;i++){
            c += i/8 + 1;
        }
        return c;
    }
}