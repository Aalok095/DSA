class Solution {
    public int finalValueAfterOperations(String[] o) {
        int x = 0;
        for (String op : o) {
            x += (op.charAt(1) == '+') ? 1 : -1;
        }
        return x;
    }
}