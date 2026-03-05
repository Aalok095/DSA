class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int z = 0,o = 0;// st with zero | st with 1
        for(int i=0;i<n;i++){
            if(i%2==0){
                if (s.charAt(i) == '0') o++;
                else z++;
            }
            else{
                if (s.charAt(i) == '0') z++;
                else o++;
            }
        }
        return Math.min(z,o);
    }
}