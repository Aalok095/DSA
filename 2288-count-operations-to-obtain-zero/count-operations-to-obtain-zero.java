class Solution {
    public int countOperations(int n1, int n2) {
        int op = 0;
        while(n1>0 && n2>0){
            if(n1>=n2) {
                n1-=n2;
            }
            else n2-=n1;
            op++;
        }
        return op;
    }
}