class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int z = 0;// st with zero
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(s.charAt(i)=='1') z++;
            } 
            else if(s.charAt(i)=='0') z++;
        }
        return Math.min(z,n-z); // st with 1
    }
}