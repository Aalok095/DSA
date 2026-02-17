class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(String ch : ops){
            if(ch.equals("C")) st.pop();
            else if(ch.equals("D")) st.push(st.peek()*2);
            else if(ch.equals("+")){
                int top = st.pop();
                int sectop = st.peek();
                st.push(top);
                st.push(top + sectop);
            }
            else st.push(Integer.parseInt(ch));
        }
        int x = 0;
        while(!st.isEmpty()) x += st.pop();
        return x;
    }
}