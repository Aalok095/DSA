class Solution {
    public int[] canSeePersonsCount(int[] h) {
        int n = h.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(h[n-1]);
        for(int i=n-2;i>=0;i--){
            int c = 0;
            while(!st.isEmpty() && st.peek()<=h[i]){
                 st.pop();
                 c++;
            }
            if(!st.isEmpty()) c++;
            ans[i] = c;
            st.push(h[i]);
        }
        return ans;
    }
}