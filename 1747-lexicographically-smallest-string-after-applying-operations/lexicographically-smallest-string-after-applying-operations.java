class Solution {

    public String rotate(String s,int b){
        StringBuilder sb = new StringBuilder(s);
        reverseRange(sb,0,b-1);
        reverseRange(sb,b,sb.length()-1);
        sb.reverse();
        return sb.toString();
    }

    public void reverseRange(StringBuilder sb,int l,int r){
        while(l<r){
            char temp = sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;r--;
        }
    }

    public String findLexSmallestString(String s, int a, int b) {
        String smallestString = s;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(s);
        visited.add(s);

        while(!q.isEmpty()){
            String curr = q.poll();
            if(curr.compareTo(smallestString) < 0) smallestString = curr;

            // a ko add karo odd positions pe mere tau ke bete
            char[] added = curr.toCharArray();
            for(int i=1;i<added.length;i+=2){
                // added[i] = ((added[i]-'0' + a) % 10) + '0';(same thing  below)
                int newDigit = ((added[i] - '0') + a) % 10;
                added[i] = (char) ('0' + newDigit);
            }

            String addedStr = new String(added);
            if(visited.add(addedStr)) q.add(addedStr);

            String rotated = rotate(curr,b);
            if(visited.add(rotated)) q.add(rotated);

        }
        return smallestString;
    }
}