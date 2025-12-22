class Solution {
    public int[][] merge(int[][] intvl) {
        Arrays.sort(intvl,(a,b) -> a[0]-b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        for(int[] i : intvl){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] < i[0]) ans.add(i);
            else {
                int[] newint = new int[2];
                newint[0] = ans.get(ans.size()-1)[0];
                newint[1] = Math.max(ans.get(ans.size()-1)[1],i[1]); 
                ans.set(ans.size()-1,newint); 
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}