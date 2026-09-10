class Solution {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return result;
    }
    public int[] helper(TreeNode root){
        if(root==null)return new int[]{0,0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int sum = left[0]+right[0]+root.val;
        int count = left[1]+right[1]+1;
        int average = sum/count;
        if(average == root.val)result++;
        return new int[]{sum,count};
    }
}