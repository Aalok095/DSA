class Solution {

    public class Pair{
        int node;
        int cost;

        public Pair(int node,int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public class Triplet implements Comparable<Triplet>{
        int node;
        int cost;
        int stops;

        public Triplet(int node,int cost,int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
        public int compareTo(Triplet t){
            if(this.stops==t.stops) return Integer.compare(this.cost,t.cost);
            return Integer.compare(this.stops,t.stops);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            int a = flights[i][0],b = flights[i][1], cost = flights[i][2];
            adj.get(a).add(new Pair(b,cost));
        }

        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(src,0,0)); // node,cost,stops
        
        while(pq.size()>0){
            Triplet top = pq.poll();
            if(top.stops==k+1) continue;
            for(Pair p : adj.get(top.node)){
                int totalCost = top.cost + p.cost;
                if(totalCost < ans[p.node]){
                    ans[p.node] = totalCost;
                    pq.add(new Triplet(p.node,totalCost,top.stops+1));
                }
            }
        }

        return ans[dst]==Integer.MAX_VALUE ? -1 : ans[dst];
    }
}