class Solution {

    public void floydWarshall(long[][] dist,char[] original,char[] changed,int[] cost){
        for(int i=0;i<original.length;i++){
            int s = original[i]-'a';
            int t = changed[i]-'a';
            dist[s][t] = Math.min(dist[s][t],cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        for(long[] row : dist) Arrays.fill(row,Integer.MAX_VALUE);

        floydWarshall(dist,original,changed,cost);

        long ans = 0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)==target.charAt(i)) continue;
            if(dist[source.charAt(i)-'a'][target.charAt(i)-'a']==Integer.MAX_VALUE) return -1;
            else ans += dist[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return ans;
    }
}