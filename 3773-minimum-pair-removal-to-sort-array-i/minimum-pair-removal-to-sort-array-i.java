class Solution {
    public boolean isSort(List<Integer> l){
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>l.get(i+1)) return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>(); 
        for(int ele : nums) arr.add(ele);
        int c = 0;
        while(!isSort(arr)){
            int msum = Integer.MAX_VALUE;//minsum
            int idx = -1;
            for(int i=0;i<arr.size()-1;i++){
                if((arr.get(i)+arr.get(i+1))<msum){
                    msum = arr.get(i)+arr.get(i+1);
                    idx = i;
                }
            }
            arr.set(idx,arr.get(idx)+arr.get(idx+1));
            arr.remove(idx+1);
            c++;
        }
        return c;
    }
}