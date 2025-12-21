class Solution {
    public int numRescueBoats(int[] p, int lim) {
        Arrays.sort(p);
        int l = 0, r = p.length-1;
        int c = 0;
        while(l<=r){
            if(p[l]+p[r]<=lim){
                l++;
                r--;
            }
            else r--;
            c++;
        }
        return c;
    }
}