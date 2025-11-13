class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int[] pre = new int[n];
        for(int i=1;i<n;i++) pre[i] = pre[i-1]+(s.charAt(i-1)-'0');
        Set<Integer> op = new HashSet<>();
        for(int i=0;i<n;i++) if(s.charAt(i)=='0') op.add(pre[i]);
        int c = 0;
        for(int ele : op) c+=ele;
        return c;
    }
}