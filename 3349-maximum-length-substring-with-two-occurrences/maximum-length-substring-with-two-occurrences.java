class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int i=0,j=0,ans = 0;
        while(j<n){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>2){
                char l = s.charAt(i);
                map.put(l,map.get(l)-1);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}