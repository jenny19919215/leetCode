package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// DFS + 回溯 ！！！ L44 copy issue  https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dy6pt/
public class PathSum {

    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> tmp= new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return result;
    }

    private void dfs(TreeNode root, int target) {
        if(root == null){
            return;
        }
        tmp.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            result.add(new LinkedList<>(tmp));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        tmp.removeLast();
    }

    public class TreeNode {
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
