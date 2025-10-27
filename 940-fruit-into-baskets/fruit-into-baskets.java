class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int i=0,j=0,maxlen = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        while(j<n){

            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            while(map.size()>2){
                map.put(fruits[i],map.getOrDefault(fruits[i],0)-1);
                if (map.get(fruits[i]) == 0) map.remove(fruits[i]);
                i++;
            }

            maxlen = Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}