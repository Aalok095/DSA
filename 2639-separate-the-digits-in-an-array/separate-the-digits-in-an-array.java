class Solution {
    public int[] separateDigits(int[] nums) {
        int  n = nums.length;
        List<Integer> l = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            int a = nums[i];
            while(a!=0){
                l.add(a%10);
                a/=10;
            }
        }
        Collections.reverse(l);
        int[] ans = new int[l.size()];
        int i=0;
        while(i<ans.length) ans[i] = l.get(i++);
        return ans;
    }
}