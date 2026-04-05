class Solution{
    public boolean judgeCircle(String m) {
        int u = 0,l = 0;
        for(char ch : m.toCharArray()){
            if(ch=='L')l++;
            if(ch=='R')l--;
            if(ch=='U')u++;
            if(ch=='D')u--;
        }
        return l==0 && u==0;
    }
}