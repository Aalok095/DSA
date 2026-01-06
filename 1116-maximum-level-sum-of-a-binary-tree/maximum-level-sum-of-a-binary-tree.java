class Solution {
    public void helper(TreeNode root, int level, List<Integer> arr) {
        if (root == null) return;

        if (arr.size() <= level) arr.add(root.val);
        else arr.set(level, arr.get(level) + root.val);

        helper(root.left,level + 1,arr);
        helper(root.right,level + 1,arr);
    }
    public int maxLevelSum(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root,0,arr);

        int max = Integer.MIN_VALUE, idx = 0;
        for (int i = 0;i < arr.size();i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
                idx = i;
            }
        }
        return idx + 1;
    }
}