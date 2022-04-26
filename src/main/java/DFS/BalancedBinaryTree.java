package DFS;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <=1 && isBalanced(root.right)&& isBalanced(root.left);
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) +1;


    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
