class Solution {
    public int minOperations(int[][] grid, int x) {
    int m = grid.length, n = grid[0].length;
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            list.add(grid[i][j]);
        }
    }
    Collections.sort(list);
    int med = list.get(list.size()/2);
    int c = 0;
    for(int ele : list){
        if(Math.abs(ele-med)%x!=0) return -1;
        c += Math.abs(ele-med)/x;
    }
    return c;
    }
}