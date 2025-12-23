class Solution {
    public int eraseOverlapIntervals(int[][] intvl) {
        Arrays.sort(intvl,(a,b) -> a[0]-b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        for(int[] i : intvl){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] <= i[0]) ans.add(i);
            else {
                int s = Math.max(ans.get(ans.size()-1)[0],i[0]);
                int e = Math.min(ans.get(ans.size()-1)[1],i[1]);
                ans.set(ans.size()-1,new int[]{s,e}); 
            }
        }
        return intvl.length-ans.size();
    }
}