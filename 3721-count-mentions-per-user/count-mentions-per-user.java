class Solution {
    public void applyMessageEvent(List<String> e,int[] mc, int[] ot) {
        int ts = Integer.parseInt(e.get(1));// ts -> time Stamp
        String[] ids = e.get(2).split(" ");

        for (String id : ids) {
            if (id.equals("ALL")) {
                for (int i = 0;i < mc.length;i++) {
                    mc[i]++;
                }

            } else if (id.equals("HERE")) {
                for (int i = 0;i < mc.length;i++) {
                    if (ot[i] == 0 || ot[i]+60 <= ts) {
                        mc[i]++;
                    }
                }

            } else {
                int userId = Integer.parseInt(id.substring(2));
                mc[userId]++;
            }
        }   
    }
    public int[] countMentions(int n, List<List<String>> events) {
        int[] mc = new int[n];// Mentions Count
        int[] ot = new int[n];// Offline time

        Collections.sort(events, (a, b) -> {// sorting done based on time -> ascending aur offline event first if t1==t2
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1==t2) {
                char c1 = a.get(0).charAt(1);
                char c2 = b.get(0).charAt(1);
                return Integer.compare(c2,c1);
            }
            return Integer.compare(t1,t2);
        });

        for (List<String> e : events) {
            if (e.get(0).equals("MESSAGE")) {
                applyMessageEvent(e,mc,ot);

            } else if (e.get(0).equals("OFFLINE")) {
                int ts = Integer.parseInt(e.get(1));// ts -> time stamp
                int id = Integer.parseInt(e.get(2));
                ot[id] = ts;
            }
        }
        return mc;
    }
}