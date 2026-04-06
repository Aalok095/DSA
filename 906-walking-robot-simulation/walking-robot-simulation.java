class Solution {
    public int robotSim(int[] com, int[][] obs) {
        Set<String> set = new HashSet<>();
        for(int[] o : obs){ // for easy searching obstacle
            set.add(o[0]+"_"+o[1]);
        }

        int x = 0,y = 0;
        int maxD = 0;

        // pointing north
        int[] dir = {0,1};

        for(int i=0;i<com.length;i++){
            if(com[i]==-1){// right 90
                dir = new int[]{dir[1],-dir[0]};
            }
            else if(com[i]==-2){ // left 90
                dir = new int[]{-dir[1],dir[0]};
            }
            else { // just move mf one step at a time
                for(int s = 0; s<com[i]; s++){
                    int newx = x+dir[0],newy = y+dir[1];
                    String newkey = newx+"_"+newy;
                    if(set.contains(newkey)) break;  
                    x = newx; y = newy;
                }
            }
            maxD = Math.max(x*x+y*y,maxD);
        }
        return maxD;
    }
}