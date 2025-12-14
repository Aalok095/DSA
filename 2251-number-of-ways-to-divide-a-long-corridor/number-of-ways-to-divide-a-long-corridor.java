class Solution {
    public int numberOfWays(String c) {
        int mod = 1000000007;
        int n = c.length();
        // list mai khali idx of seat store karo.
        // 2 2 seat k pair mai division nahi kar sakte 
        // just find length of those rem mf ind and multiply them
        List<Integer> pos = new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = c.charAt(i);
            if(ch=='S') pos.add(i);
        }

        if(pos.size()%2!=0 || pos.size()==0) return 0;
        
        long ans = 1;
        int prev = pos.get(1);
        for(int i=2;i<pos.size();i+=2){
            int len = pos.get(i) - prev;
            ans = (ans * len) % mod;
            prev = pos.get(i+1);
        }
        return (int)ans;
    }
}