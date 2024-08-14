import org.dorum.algo.Trees;
import org.dorum.algo.Trees.*;
import org.junit.jupiter.api.Test;

import static org.dorum.algo.Trees.*;

public class TreesTest {

    private static final TreeNode ROOT_NODE_3;
    private static final TreeNode NODE_1;
    private static final TreeNode NODE_3;
    private static final TreeNode NODE_4;
    private static final TreeNode NODE_5;
    private static final TreeNode NODE_9;
    private static final TreeNode NODE_11;
    private static final TreeNode NODE_15;
    private static final TreeNode NODE_20;

    static {
        NODE_20 = new Trees.TreeNode(20);
        NODE_20.left = new TreeNode(15);
        NODE_20.right = new TreeNode(7);

        ROOT_NODE_3 = new TreeNode(3);
        ROOT_NODE_3.left = new TreeNode(9);
        ROOT_NODE_3.right = NODE_20;

        NODE_1 = new TreeNode(2);
        NODE_1.left = new TreeNode(1);
        NODE_1.right = new TreeNode(3);

        NODE_4 = new TreeNode(4);
        NODE_4.left = new TreeNode(3);
        NODE_4.right = new TreeNode(6);

        NODE_5 = new TreeNode(5);
        NODE_5.left = new TreeNode(1);
        NODE_5.right = NODE_4;

        NODE_3 = new TreeNode(3);
        NODE_3.left = new TreeNode(1);
        NODE_3.right = new TreeNode(5);

        NODE_9 = new TreeNode(9);
        NODE_9.left = NODE_3;

        NODE_15 = new TreeNode(15);
        NODE_15.right = new TreeNode(17);

        NODE_11 = new TreeNode(11);
        NODE_11.left = NODE_9;
        NODE_11.right = NODE_15;
    }

    @Test
    public void maxSumTest() {
        System.out.println(maxSum(NODE_1));
    }

    @Test
    public void isValidBSTTest() {
        System.out.println(isValidBST(NODE_11));
        System.out.println(isValidBST(NODE_5));
    }

    @Test
    public void isValidBSTInorderTraversalTest() {
        System.out.println(isValidBSTInorderTraversal(NODE_11));
    }
}
