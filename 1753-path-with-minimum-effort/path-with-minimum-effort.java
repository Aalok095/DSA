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

        PriorityQueue<Triplet> pq = new PriorityQueue<>();// bkl Dijkstra suru
        pq.add(new Triplet(0,0,0));

        while(pq.size()>0){

            Triplet top = pq.poll();
            int row = top.row,col = top.col,effort = top.effort;

            if(row>0){// going up

                int e = Math.abs(arr[row][col]-arr[row-1][col]);
                e = Math.max(e,effort);

                if(e < ans[row-1][col]){
                    ans[row-1][col] = e;
                    pq.add(new Triplet(row-1,col,e));
                }
            }

            if(col>0){ // going left

                int e = Math.abs(arr[row][col]-arr[row][col-1]);
                e = Math.max(e,effort);

                if(e < ans[row][col-1]){
                    ans[row][col-1] = e;
                    pq.add(new Triplet(row,col-1,e));
                }
            }

            if(row<m-1){// going down

                int e = Math.abs(arr[row][col]-arr[row+1][col]);
                e = Math.max(e,effort);

                if(e < ans[row+1][col]){
                    ans[row+1][col] = e;
                    pq.add(new Triplet(row+1,col,e));
                }
            }
            if(col<n-1){// goint right

                int e = Math.abs(arr[row][col]-arr[row][col+1]);
                e = Math.max(e,effort);

                if(e < ans[row][col+1]){
                    ans[row][col+1] = e;
                    pq.add(new Triplet(row,col+1,e));
                }
            }
        }

        return ans[m-1][n-1];
    }
}