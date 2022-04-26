package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFSDFSmaxDepth {

    public int maxDepthBFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = 0;
        Queue<BFSDFSmaxDepth.TreeNode> queue = new LinkedList<BFSDFSmaxDepth.TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                BFSDFSmaxDepth.TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result++;

        }

        return result;

    }

    public int maxDepthDFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxleft= maxDepthDFS(root.left);
        int maxright = maxDepthDFS(root.right);

        return Math.max(maxleft,maxright) +1;
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
