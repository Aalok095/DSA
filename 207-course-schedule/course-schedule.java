class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        int[] in = new int[n]; // indegree array

        for(int[] p : prereq){
            int a = p[0],b = p[1]; // b -> a edge ja rahi hai
            adj.get(b).add(a);
            in[a]++;// populating indegree too
        }

        // kahn's algorithm
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);
        
        while(q.size()>0){
            int front = q.poll();
            ans.add(front);
            for(int ele : adj.get(front)){
                in[ele]--;
                if(in[ele]==0) q.add(ele);
            }
        }
        return ans.size()==n;
    }
}