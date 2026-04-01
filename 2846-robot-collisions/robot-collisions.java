class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] health, String dir) {
        int n = pos.length;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++) idx[i] = i;

        Arrays.sort(idx,(a,b)->Integer.compare(pos[a],pos[b])); // actual idx 

        Stack<Integer> st = new Stack<>();
        List<Integer> res = new ArrayList<>();

        for(int i : idx){
            if(dir.charAt(i)=='R') st.push(i);
            else {
                while(!st.isEmpty() && health[i]>0){

                    int top = st.pop();

                    if(health[top]>health[i]){
                        health[top] -= 1;
                        health[i] = 0;
                        st.push(top);
                    }
                    else if(health[top] < health[i]){
                        health[top] = 0;
                        health[i] -= 1;
                    }
                    else {
                        health[i] = 0;
                        health[top] = 0;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(health[i]>0) res.add(health[i]);
        }
        return res;
    }
}