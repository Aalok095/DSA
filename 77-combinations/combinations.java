class Solution {
    public void backtrack(List<List<Integer>> ans,int start,int n,int k,List<Integer> list){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            backtrack(ans,i+1,n,k,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {n};
        backtrack(ans,1,n,k,new ArrayList<>());
        return ans;
    }
}