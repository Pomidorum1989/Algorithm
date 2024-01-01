package org.dorum;

import java.util.*;
import java.util.LinkedList;

public class Trees {

    public static void main(String[] args) {
//        TreeNode node20 = new TreeNode(20);
//        node20.left = new TreeNode(15);
//        node20.right = new TreeNode(7);
//
//        TreeNode rootNode3 = new TreeNode(3);
//        rootNode3.left = new TreeNode(9);
//        rootNode3.right = node20;
//
//        TreeNode node1 = new TreeNode(2);
//        node1.left = new TreeNode(1);
//        node1.right = new TreeNode(3);
//
//        System.out.println(maxSum(node1));
//
//        TreeNode node4 = new TreeNode(4);
//        node4.left = new TreeNode(3);
//        node4.right = new TreeNode(6);
//        TreeNode node5 = new TreeNode(5);
//        node5.left = new TreeNode(1);;
//        node5.right = node4;


        TreeNode node3 = new TreeNode(3);
        node3.left = new TreeNode(1);
        node3.right = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        node9.left = node3;
        TreeNode node15 = new TreeNode(15);
        node15.right = new TreeNode(17);
        TreeNode node11 = new TreeNode(11);
        node11.left = node9;
        node11.right = node15;

//        System.out.println(isValidBST(node11));
//        System.out.println(isValidBSTInorderTraversal(node11));
//        System.out.println(isValidBST(node5));
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return this.val + "";
        }
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        return root.val + left + right;
    }

    public static boolean ifValueExist(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        boolean isLeft = ifValueExist(root.left, value);
        boolean isRight = ifValueExist(root.right, value);
        return root.val == value || isLeft || isRight;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
    public static boolean isValidBST(TreeNode root) {
        return isNodeValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isNodeValid(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        } else if (root.val <= left || root.val >= right) {
            return false;
        }
        return isNodeValid(root.left, left, root.val) &&
                isNodeValid(root.right, root.val, right);
    }

    public static boolean isValidBSTInorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        int previousNodeVal = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (previousNodeVal >= list.get(i)) {
                return false;
            }
            previousNodeVal = list.get(i);
        }
        return true;
    }

    public static void helper(TreeNode node, List<Integer> linkedList) {
        if (node == null) {
            return;
        }
        helper(node.left, linkedList);
        linkedList.add(node.val);
        helper(node.right, linkedList);
    }

}
