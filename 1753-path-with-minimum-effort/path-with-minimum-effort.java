class Solution {

    public class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int effort;

        public Triplet(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.effort = dist;
        }

        public int compareTo(Triplet t){
            if(this.effort==t.effort) return Integer.compare(this.row,t.row);
            return Integer.compare(this.effort,t.effort);
        }
    }

    public int minimumEffortPath(int[][] arr) {
        int m = arr.length, n = arr[0].length;

        int[][] ans = new int[m][n];
        for(int[] row : ans) Arrays.fill(row,Integer.MAX_VALUE);
        ans[0][0] = 0;

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<Triplet> pq = new PriorityQueue<>();// bkl Dijkstra suru
        pq.add(new Triplet(0,0,0));

        while(pq.size()>0){

            Triplet top = pq.poll();
            int row = top.row,col = top.col,effort = top.effort;
            if(row==m-1 && col==n-1) break; // min heap mai aa gaya ans m-1,n-1 wala 
            
            for(int i=0;i<4;i++){

                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;

                int e = Math.abs(arr[row][col]-arr[nr][nc]);
                e = Math.max(e,effort);

                if(e < ans[nr][nc]){
                    ans[nr][nc] = e;
                    pq.add(new Triplet(nr,nc,e));
                }
            }
        }
        return ans[m-1][n-1];
    }
}