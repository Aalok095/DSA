class Solution {

    public boolean helper(String a,String b){

        if(a.length()!=b.length()) return false;

        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();

        Arrays.sort(arr);
        Arrays.sort(brr);

        return Arrays.equals(arr,brr);
    }

    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
    
        for(int i=1;i<n;i++){
            if(!helper(words[i],words[i-1])) list.add(words[i]);
        }

        return list;
    }
}