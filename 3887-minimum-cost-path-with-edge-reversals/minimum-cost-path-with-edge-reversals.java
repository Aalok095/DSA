class Solution {

    class Pair implements Comparable<Pair>{
        int node;
        int cost;
        
        public Pair(int node,int cost){
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Pair p){
            if(this.cost==p.cost) return Integer.compare(this.node,p.node);
            return Integer.compare(this.cost,p.cost);
        }
    }
    
    public int minCost(int n,int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            int a = e[0],b = e[1],c = e[2];
            adj.get(a).add(new Pair(b,c));
            adj.get(b).add(new Pair(a,2*c));
        }

        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        while(pq.size()>0){
            Pair t = pq.poll();
            if(ans[t.node] < t.cost) continue;

            for(Pair p : adj.get(t.node)){
                int total = t.cost + p.cost;
                if(ans[p.node] > total){
                    ans[p.node] = total;
                    pq.add(new Pair(p.node,total));
                }
            }
        }

        return ans[n-1]==Integer.MAX_VALUE ? -1 : ans[n-1];
    }
}