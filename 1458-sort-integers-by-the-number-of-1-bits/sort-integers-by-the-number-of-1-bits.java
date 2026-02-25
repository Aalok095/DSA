class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] ans = new Integer[n];
        for(int i=0;i<n;i++) ans[i] = arr[i];
        Arrays.sort(ans, (a,b) -> {
            int cA = Integer.bitCount(a);
            int cB = Integer.bitCount(b);
            if (cA == cB) return Integer.compare(a,b);
            return Integer.compare(cA,cB);
        });
        for(int i=0;i<n;i++) arr[i] = ans[i];
        return arr;
    }
}