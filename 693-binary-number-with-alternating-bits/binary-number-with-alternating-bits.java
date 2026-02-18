class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        int i = 0,j=1,l = s.length();
        while(j<l){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1==c2) return false;
            i++;
            j++;
        }
        return true;
    }
}