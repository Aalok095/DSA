class Solution {
    public int maximumUnits(int[][] bt,int t) {
        Arrays.sort(bt,(a,b) -> b[1]-a[1]);// decreasing
        int s = 0;
        for(int i=0;i<bt.length;i++){
            int nb = bt[i][0];// no of boxes
            int ub = bt[i][1];// units per boxes
            int min = Math.min(nb,t);
            t-=min;
            s += min*ub;
            if(t==0) return s;
        }
        return s;
    }
}