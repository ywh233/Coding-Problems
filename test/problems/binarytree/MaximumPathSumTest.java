package problems.binarytree;

import model.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

import static utils.BinaryTreeUtility.*;

public class MaximumPathSumTest {

    @Test
    public void testMaximumPathSum() throws Exception {
        BinaryTreeNode<Integer> tree1 = createTree(1);
        BinaryTreeNode<Integer> tree2 = createTree(3,2,7,4,5,1,6);
        BinaryTreeNode<Integer> tree3 = createTree(1,9,2,5,8,1,1);

        assertEquals(1, MaximumPathSum.maximumPathSum(tree1));
        assertEquals(23, MaximumPathSum.maximumPathSum(tree2));
        assertEquals(22, MaximumPathSum.maximumPathSum(tree3));
    }
}