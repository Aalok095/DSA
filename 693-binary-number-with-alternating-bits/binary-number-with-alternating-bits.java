class Solution {
    public boolean hasAlternatingBits(int n) {
        int res = n ^ (n >> 1); 
        return (res & (res + 1)) == 0;
    }
}