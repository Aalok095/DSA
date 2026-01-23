class Solution {
    static class Pair implements Comparable<Pair> {
        long sum;
        int idx;

        Pair(long sum,int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            if (this.sum == p.sum) return Integer.compare(this.idx,p.idx);
            return Long.compare(this.sum,p.sum);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        TreeSet<Pair> pairs = new TreeSet<>();

        int[] next = new int[n];
        int[] prev = new int[n];

        for (int i = 0;i < n;i++) {
            next[i] = i + 1;
            prev[i] = i - 1;
        }

        int badCount = 0;
        for (int i = 0;i < n-1;i++) {
            if (arr[i] > arr[i + 1]) badCount++;
            pairs.add(new Pair(arr[i] + arr[i + 1], i));
        }

        int c = 0;
        while(badCount > 0) {

            Pair f = pairs.first();
            pairs.remove(f);

            int first = f.idx;
            int second = next[first];

            int left = prev[first];
            int right = next[second];

            // remove bad pair (first,second)
            if (arr[first] > arr[second]) badCount--;

            // update effect on pair (left,first)
            if (left >= 0) {
                if (arr[left] > arr[first] && arr[left] <= arr[first] + arr[second]) badCount--;
                else if (arr[left] <= arr[first] && arr[left] > arr[first] + arr[second]) badCount++;
            }

            // update effect on pair (second,right)
            if (right < n) {
                if (arr[right] >= arr[second] && arr[right] < arr[first] + arr[second]) badCount++;
                else if (arr[right] < arr[second] && arr[right] >= arr[first] + arr[second]) badCount--;
            }

            // update pair sums in TreeSet for left side
            if (left >= 0) {
                pairs.remove(new Pair(arr[left] + arr[first],left));
                pairs.add(new Pair(arr[left] + arr[first] + arr[second],left));
            }

            // update pair sums in TreeSet for right side
            if (right < n) {
                pairs.remove(new Pair(arr[second] + arr[right], second));
                pairs.add(new Pair(arr[first] + arr[second] + arr[right],first));
                prev[right] = first;
            }

            next[first] = right;// merge first and second
            arr[first] += arr[second];
            c++;
        }
        return c;
    }
}
