class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int time;
        public Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair p){
            if(this.time==p.time) return this.node - p.node;
            return this.time - p.time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int src) {

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<Pair>());

        for(int[] t : times){
            int u = t[0], v = t[1], time = t[2];
            adj.get(u).add(new Pair(v,time));
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;

        // Dijkstras algo
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){

            Pair top = pq.poll();
            int node = top.node ,time = top.time;

            if(time > ans[node]) continue;

            for(Pair p : adj.get(node)){
                int totalTime = time + p.time;
                if(totalTime < ans[p.node]){
                    ans[p.node] = totalTime;
                    pq.add(new Pair(p.node,totalTime));
                }
            }
        }

        int a = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) a = Math.max(a,ans[i]);
        return a==Integer.MAX_VALUE ? -1 : a; 
    }
}