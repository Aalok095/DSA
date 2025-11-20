class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1]) return b[0] - a[0];// sort decreasing
            return a[1] - b[1];// sort increasing
        });

        int res = 0;
        int first = -1,second = -1;

        for(int i=0;i<n;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];

            if(l<=first) continue;// corner case mf
            if(l>second){ // no intersextion possible
                res+=2;
                first = r-1;
                second = r;
            }
            else {// 1 pt intersection possible or (l<=second)
                res += 1;
                first = second;
                second = r;
            }
        }
        return res;
    }
}