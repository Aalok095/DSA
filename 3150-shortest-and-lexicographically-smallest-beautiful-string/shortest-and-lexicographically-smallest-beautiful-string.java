class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int n = s.length();
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            String t = "";
            int c = 0;
            int len = 0;
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                t += ch;
                if(ch=='1') c++;
                len = j-i+1;
                if(c==k){
                    if(min>len){
                        min = len;
                        ans = t;
                    }
                    else if(len==min && t.compareTo(ans)<0) ans = t;
                    break;
                }
            }
        }
        return ans;
    }
}