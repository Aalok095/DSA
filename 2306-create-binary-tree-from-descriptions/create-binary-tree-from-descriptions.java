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
    public TreeNode createBinaryTree(int[][] des) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,TreeNode> map = new HashMap<>();
        for(int[] d : des){
            int p = d[0],c = d[1],isLeft = d[2];
            set.add(c);
            if(map.get(p)==null) map.put(p,new TreeNode(p));
            if(map.get(c)==null) map.put(c,new TreeNode(c));
            if(isLeft==1) map.get(p).left = map.get(c);
            else map.get(p).right = map.get(c);
        }
        for(int[] d : des){
            if(!set.contains(d[0])) return map.get(d[0]);
        }
        return null;
    }
}