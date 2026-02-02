class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeSet<int[]> kmin = new TreeSet<>((a,b)->{ // (value,idx)
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        TreeSet<int[]> rem = new TreeSet<>((a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        long sum = 0;
        int i = 1;
        while(i<n && i-dist<1){ // First window [1.......dist+1]
            int[] cur = new int[]{nums[i],i};
            kmin.add(cur);
            sum += nums[i];

            if(kmin.size()>k-1){
                int[] largest = kmin.pollLast();
                sum -= largest[0];
                rem.add(largest);
            }
            i++;
        }

        long res = Long.MAX_VALUE;

        // sliding window here we go
        while(i<n){
            int[] cur = new int[]{nums[i], i};
            kmin.add(cur);
            sum += nums[i];

            if(kmin.size() > k - 1) {
                int[] largest = kmin.pollLast();
                sum -= largest[0];
                rem.add(largest);
            }
            res = Math.min(res,sum);

            int remIdx = i-dist;
            int[] toRemove = new int[]{nums[remIdx],remIdx};

            if(kmin.remove(toRemove)){
                sum -= nums[remIdx];

                if(!rem.isEmpty()){
                    int[] promote = rem.pollFirst();
                    kmin.add(promote);
                    sum += promote[0];
                }
            }
            else rem.remove(toRemove);
            i++;
        }
        return nums[0]+res;
    }
}