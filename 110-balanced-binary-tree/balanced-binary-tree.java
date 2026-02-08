class Solution {
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(level(root.left),level(root.right));
    }
    public void helper(TreeNode root,int[] ans){
        if(root==null) return;
        int l = level(root.left);
        int r = level(root.right);
        if(Math.abs(l-r)>1){
            ans[0] = 1;
            return;
        } 
        helper(root.left,ans);
        helper(root.right,ans);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int[] ans = {0};
        helper(root,ans);
        return ans[0]!=1;
    }
}