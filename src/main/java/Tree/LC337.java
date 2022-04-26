package Tree;

public class LC337 {
    private int max =0;

    public int rob(TreeNode root) {
        robByNode(root);
        return max;
    }

    private int robByNode(TreeNode root) {
        if(root == null) return 0;
        int ans=0; int ans2=0;
        if(root.left != null){
            ans +=robByNode(root.left.left)+robByNode(root.left.right);
        }
        if(root.right != null){
            ans +=robByNode(root.right.left)+robByNode(root.right.right);
        }

        ans+=root.val;
        max = Math.max(ans,max);
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
