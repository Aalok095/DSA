class Solution {
    public int maximizeSquareArea(int m, int n, int[] hf, int[] vf) {
        List<Integer> hlist = new ArrayList<>();
        List<Integer> vlist = new ArrayList<>();

        hlist.add(1);// boundaries
        hlist.add(m);
        vlist.add(1);
        vlist.add(n);

        for(int ele : hf) hlist.add(ele);
        for(int ele : vf) vlist.add(ele);

        Collections.sort(hlist);
        Collections.sort(vlist);

        Set<Integer> width = new HashSet<>();
        // all vertical widths
        for (int i = 0;i < vlist.size();i++) {
            for (int j = i + 1;j < vlist.size();j++) {
                width.add(vlist.get(j) - vlist.get(i));
            }
        }

        int maxSide = 0;

        for (int i = 0;i < hlist.size();i++) {// check horizontal heights
            for (int j = i + 1;j < hlist.size();j++) {
                int height = hlist.get(j) - hlist.get(i);
                if (width.contains(height)) {
                    maxSide = Math.max(maxSide,height);
                }
            }
        }

        if (maxSide == 0) return -1;

        long area = (long) maxSide*maxSide;
        return (int) (area % 1000000007);
    }
}