package DivideandConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintNumbers {
    public static List<Integer> diffWaysToCompute(String input) {//241!!!!!!!!!!??????????
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public int solution(int[] A) {
        int min = 1;
        if (A == null) {
            return min;
        }
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) continue;
            if (i > 0 && A[i - 1] >= 0 && A[i] - A[i - 1] > 1) {
                min = A[i - 1] + 1;
                flag = true;
                break;
            }
            if (i > 0 && A[i - 1] < 0 && A[i] - A[i - 1] > 2 && A[i] != 1) {
                min = A[i] - 1;
                flag = true;
                break;
            }

        }
        if (!flag) {
            min = A[A.length - 1] > 0 ? A[A.length - 1] + 1 : min;
        }


        return min;


    }

    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args){
        List<Integer> list = diffWaysToCompute("2*3+5*4");
        List<TreeNode> treeNodes = generateTrees(3);
    }

    //https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/594wfg/
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10,n)-1);
        int[] res = new int[max];
        for(int i =0;i<max;i++){
            res[i] = i+1;
        }
        return res;

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
