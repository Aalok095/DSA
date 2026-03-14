class Solution {
    public void solve(int n, StringBuilder curr, List<String> res) {
        if (curr.length() == n) {
            res.add(curr.toString());
            return;
        }
        for (char ch = 'a';ch <= 'c';ch++) {
            if (curr.length() > 0 && curr.charAt(curr.length()-1)==ch)continue;
            curr.append(ch);// Do
            solve(n,curr,res);// Explore
            curr.deleteCharAt(curr.length() - 1);// Undo
        }
    }

    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();
        solve(n, curr, res);
        if (res.size() < k) return "";
        return res.get(k-1);
    }
}