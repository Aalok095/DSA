class Solution {
    public List<Integer> findAllPeople(int n, int[][] meet, int fp) {
        // meeting ko ascending order mai sort karo if more than one meeting at same time make a list
        Map<Integer,List<int[]>> timeMeetings = new TreeMap<>();
        for(int[] m : meet){
            int x = m[0],y = m[1],t = m[2];
            timeMeetings.computeIfAbsent(t,k -> new ArrayList<>()).add(new int[]{x,y});
        }

        // Boolean Array to mark if a person knows the secret or not
        boolean[] ks = new boolean[n];// ks -> knows Secret
        ks[0] = true;
        ks[fp] = true;

        for(int t : timeMeetings.keySet()){
            // For each person, save all the people whom he/she meets at time t
            // basically making a adjacency list
            Map<Integer,List<Integer>> meetList = new HashMap<>();
            for (int[] m : timeMeetings.get(t)) {
                int x = m[0],y = m[1];
                meetList.computeIfAbsent(x,k -> new ArrayList<>()).add(y);
                meetList.computeIfAbsent(y,k -> new ArrayList<>()).add(x);
            }

            // Set to avoid redundancy
            Set<Integer> start = new HashSet<>();
                for (int[] m : timeMeetings.get(t)) {
                    int x = m[0], y = m[1];
                    if (ks[x]) start.add(x);
                    if (ks[y]) start.add(y);
                }

            // BFS
            Queue<Integer> q = new LinkedList<>(start);
            while(!q.isEmpty()){
                int person = q.poll();
                for(int nextPerson : meetList.getOrDefault(person,new ArrayList<>())){
                    if(!ks[nextPerson]){
                        ks[nextPerson] = true;
                        q.offer(nextPerson);
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ks[i]) res.add(i);
        }
        return res;
    }
}