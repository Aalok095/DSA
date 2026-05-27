class Solution {
    public int numberOfSpecialChars(String w) {
        int n = w.length();
        int c = 0;
        HashMap<Character,List<Integer>> m1 = new HashMap<>();
        HashMap<Character,List<Integer>> m2 = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = w.charAt(i);
            if(ch>='a' && ch<='z') m1.computeIfAbsent(ch, k-> new ArrayList<>()).add(i);
            else m2.computeIfAbsent(ch,k -> new ArrayList<>()).add(i);
        }
        for(char key : m1.keySet()){
            List<Integer> t1 = m1.get(key);
            List<Integer> t2 = m2.get(Character.toUpperCase(key));
            if(t2==null) continue;
            if(t1.get(t1.size()-1)<t2.get(0)) c++;
        }
        return c;
    }
}