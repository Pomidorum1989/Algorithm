import org.dorum.algo.Trees;

public class TreesTest {
    public static void main(String[] args) {
//        TreeNode node20 = new TreeNode(20);
//        node20.left = new TreeNode(15);
//        node20.right = new TreeNode(7);

//        TreeNode rootNode3 = new TreeNode(3);
//        rootNode3.left = new TreeNode(9);
//        rootNode3.right = node20;

//        TreeNode node1 = new TreeNode(2);
//        node1.left = new TreeNode(1);
//        node1.right = new TreeNode(3);

//        System.out.println(maxSum(node1));

//        TreeNode node4 = new TreeNode(4);
//        node4.left = new TreeNode(3);
//        node4.right = new TreeNode(6);
//        TreeNode node5 = new TreeNode(5);
//        node5.left = new TreeNode(1);;
//        node5.right = node4;

        Trees.TreeNode node3 = new Trees.TreeNode(3);
        node3.left = new Trees.TreeNode(1);
        node3.right = new Trees.TreeNode(5);
        Trees.TreeNode node9 = new Trees.TreeNode(9);
        node9.left = node3;
        Trees.TreeNode node15 = new Trees.TreeNode(15);
        node15.right = new Trees.TreeNode(17);
        Trees.TreeNode node11 = new Trees.TreeNode(11);
        node11.left = node9;
        node11.right = node15;

//        System.out.println(isValidBST(node11));
//        System.out.println(isValidBSTInorderTraversal(node11));
//        System.out.println(isValidBST(node5));
    }
}
