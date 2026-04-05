class Solution{
    public boolean judgeCircle(String m) {
        int u = 0,l = 0;
        for(char ch : m.toCharArray()){
            if(ch=='L')l++;
            else if(ch=='R')l--;
            else if(ch=='U')u++;
            else if(ch=='D')u--;
        }
        return l==0 && u==0;
    }
}