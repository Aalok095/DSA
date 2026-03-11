class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch=='0') sb.append('1');
            else sb.append('0');
        }
        return Integer.parseInt(sb.toString(),2);
    }
}