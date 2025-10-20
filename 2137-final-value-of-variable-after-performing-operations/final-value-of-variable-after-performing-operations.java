class Solution {
    public int finalValueAfterOperations(String[] o) {
        int x = 0;
        for(String ele : o){
            if(ele.equals("--X") || ele.equals("X--")) x-=1;
            else x+=1;
        }
        return x;
    }
}