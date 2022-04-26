package Tree;

public class LC687 {
    private static int max =0;

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        LC687 lc687 = new LC687();
        System.out.println(lc687.longestUnivaluePath(root));

    }

    public int longestUnivaluePath(TreeNode root) {
        longestUnivalue(root);
        return max;

    }


    public int longestUnivalue(TreeNode root) {
        if(root == null) return 0;
        int leftLen =longestUnivalue(root.left); int rightLen =longestUnivalue(root.right);
        if(root.left !=null && root.left.val == root.val) {

            leftLen=1+ leftLen;

        }
        if(root.right !=null && root.right.val == root.val) {

            rightLen = 1+rightLen;
        }

        max =Math.max(leftLen+rightLen,max);

        return Math.max(leftLen,rightLen);
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
