class Solution {
    public int minimumIndex(int[] cap, int it) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cap.length;i++){
            if(cap[i]>=it){
                min = Math.min(min,cap[i]);
            }
        }   
        for(int i = 0;i<cap.length;i++) if(cap[i]==min) return i;
        return -1;
    }
}