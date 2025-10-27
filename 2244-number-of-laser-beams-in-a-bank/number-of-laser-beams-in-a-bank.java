class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prev = 0,res = 0;

        for(int i=0;i<n;i++){
            int curr = 0;
            for(char ch : bank[i].toCharArray()){
                if(ch=='1') curr++;
            }
            res += curr*prev;
            if(curr!=0){
                prev = curr;
            }
        }
        return res;
    }
}