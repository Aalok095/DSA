/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int levels(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int leftLevels = levels(root.left,dp);
        int rightLevels = levels(root.right,dp);
        dp.put(root,1+Math.max(leftLevels,rightLevels));
        return dp.get(root);
    }
    public int diameter(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null) return 0;
        int dia = levels(root.left,dp)+levels(root.right,dp);
        int leftDia = diameter(root.left,dp);
        int rightDia = diameter(root.right,dp);
        return Math.max(dia,Math.max(leftDia,rightDia));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        HashMap<TreeNode,Integer> dp = new HashMap<>();
        return diameter(root,dp);
    }
}