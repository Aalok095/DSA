class Solution {
    public int minimumBoxes(int[] ap, int[] cap) {
        int s = 0;
        for(int ele : ap) s += ele;
        Arrays.sort(cap);
        int j = cap.length-1,c = 0;
        while(s>0){
            s-=cap[j];
            c++;
            j--;
        }
        return c;
    }
}