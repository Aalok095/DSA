class Solution {
    public String makeLargestSpecial(String s) {
        int start = 0;
        int sum = 0;
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            sum += (s.charAt(i)=='1') ? 1 : -1;
            if(sum==0){
                String inner = s.substring(start+1,i);
                list.add("1"+makeLargestSpecial(inner)+"0");
                start = i+1;
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String ele : list) sb.append(ele);
        return sb.toString();
    }
}