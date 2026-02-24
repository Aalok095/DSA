class Solution {
    public void helper(TreeNode root,String s,int[] sum){
        if(root==null) return;
        s+=root.val;
        if(root.left==null && root.right==null){
            if(!s.isEmpty()) sum[0] += Integer.parseInt(s,2);
            return;
        }
        helper(root.left,s,sum);
        helper(root.right,s,sum);
    }
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = {0};
        helper(root,"",sum);
        return sum[0];
    }
}