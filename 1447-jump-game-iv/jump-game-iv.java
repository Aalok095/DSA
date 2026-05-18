class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
    
        Map<Integer,List<Integer>> map = new HashMap<>();//to jump arr[i] = arr[j]
        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        int c = 0;

        boolean[] vis = new boolean[n];
        vis[0] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        while(!q.isEmpty()){
            int s = q.size();
            while(s-->0){
                int f = q.poll();
                if(f==n-1) return c;
                int l = f-1;
                int r = f+1;  
                if(l>=0 && !vis[l]){
                    vis[l] = true;
                    q.add(l);
                }
                if(r<n && !vis[r]){
                    vis[r] = true;
                    q.add(r);
                }

                List<Integer> same = map.get(arr[f]);
                if(same != null){
                    for(int idx : same){
                        if(!vis[idx]){
                            vis[idx] = true;
                            q.add(idx);
                        }
                    }
                    map.remove(arr[f]);
                }
            }
            c++;
        }
        return -1;
    }
}