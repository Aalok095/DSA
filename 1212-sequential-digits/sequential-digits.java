class Solution {
    public List<Integer> sequentialDigits(int l, int h) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=8;i++) q.add(i);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int t = q.poll();
            if(t>=l && t<=h) ans.add(t);
            int ld = t%10;
            if(ld+1<=9) q.add(t*10+(ld+1));
        }
        return ans;
    }
}