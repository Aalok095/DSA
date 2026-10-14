class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder("");
        while(num-->0){
            if(sum>=9){
                sb.append("9");
                sum -= 9;
            }
            else if(sum>0 && sum<9){
                sb.append(sum);
                sum = 0;
            }
            else sb.append("0");
        }
        if(sum!=0) return "";
        return sb.toString();
    }
}