class Solution {

    public class Triplet implements Comparable<Triplet>{
        int node;
        int parent;
        int dist;

        public Triplet(int node,int parent,int dist){
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
        
        public int compareTo(Triplet t){
            if(this.dist==t.dist) return Integer.compare(this.node,t.node);
            return Integer.compare(this.dist,t.dist);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));// idx, parent , distance

        int sum = 0;
        boolean[] vis = new boolean[n];
        
        while(pq.size()>0){
            Triplet top = pq.poll();

            if(vis[top.node]) continue;

            vis[top.node] = true;
            sum += top.dist;

            for(int i=0;i<n;i++){

                if(i==top.node || i==top.parent) continue;
                if(vis[i]) continue;

                int x1 = points[top.node][0],y1 = points[top.node][1];
                int x2 = points[i][0],y2 = points[i][1];

                int manhatan = Math.abs(x2-x1) + Math.abs(y2-y1);
                pq.add(new Triplet(i,top.node,manhatan));
            }
        }
        return sum;
    }
}