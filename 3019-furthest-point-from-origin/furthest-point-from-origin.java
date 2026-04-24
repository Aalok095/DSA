class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0,r = 0,d = 0;
        for(char ele : moves.toCharArray()){
            if(ele=='L') l++;
            else if(ele=='R') r++;
            else d++;
        }
        if(l==r) return l+d-r;
        return Math.max(l,r)+d-Math.min(l,r);
    }
}