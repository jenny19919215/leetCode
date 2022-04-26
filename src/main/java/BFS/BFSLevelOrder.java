package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9ab39g/
public class BFSLevelOrder {
     public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        List result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            char a ='2'-'1';
        }

        return result.stream().mapToInt( num -> ((Integer)num).intValue() ).toArray();




     }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
