package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        Set<String> result = new HashSet<>();
        StringBuilder tmp = new StringBuilder();
        dfs(root,tmp,result);
        return new ArrayList<>(result);

    }

    private void dfs(TreeNode root, StringBuilder tmp, Set<String> result) {
        if(root == null) return;
        int len = tmp.length();
        tmp.append(root.val);
        if(root.left == null && root.right == null){
            result.add(tmp.toString());
            tmp.delete(len,tmp.length());
            return;
        }
        tmp.append("->");
        dfs(root.left,tmp,result);
        dfs(root.right,tmp,result);
        tmp.delete(len,tmp.length());

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
