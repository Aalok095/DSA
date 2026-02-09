class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return buildBalancedBST(list, 0, list.size() - 1);
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    private TreeNode buildBalancedBST(List<Integer> list, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalancedBST(list, lo, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, hi);
        return node;
    }
}