package DFS;

public class SymmtricBinaryTree {

      public boolean isSymmetric(TreeNode root) {
          if (root == null) {
              return true;
          }
          return is2TreeSymmetric(root.left, root.right);

    }

    private boolean is2TreeSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null ) return false;
        if(left.val == right.val){
            return is2TreeSymmetric(left.left,right.right) && is2TreeSymmetric(left.right,right.left);
        }
        return false;
    }

    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
