package org.dorum.algo;

import org.dorum.utils.RecordMethodInfo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.dorum.algo.LeetCode.LC_150;

public class Trees {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
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

    /**
     * <a href="{@link LeetCode#LC_150}94/trees/555/">maxDepth</a>
     */
    @RecordMethodInfo(link = LC_150 + "94/trees/555/")
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    @RecordMethodInfo()
    public static int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        return root.val + left + right;
    }

    @RecordMethodInfo()
    public static boolean ifValueExist(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        boolean isLeft = ifValueExist(root.left, value);
        boolean isRight = ifValueExist(root.right, value);
        return root.val == value || isLeft || isRight;
    }


    /**
     * <a href="{@link LeetCode#LC_150}94/trees/555/">maxDepthBFS</a>
     */
    @RecordMethodInfo(link = LC_150 + "94/trees/555/")
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

    /**
     * <a href="{@link LeetCode#LC_150}94/trees/625/">isValidBST</a>
     */
    @RecordMethodInfo(link = LC_150 + "94/trees/625/")
    public static boolean isValidBST(TreeNode root) {
        return isNodeValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isNodeValid(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        } else if (root.val <= left || root.val >= right) {
            return false;
        }
        return isNodeValid(root.left, left, root.val) && isNodeValid(root.right, root.val, right);
    }

    @RecordMethodInfo()
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
