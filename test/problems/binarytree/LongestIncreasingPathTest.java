package problems.binarytree;

import model.BinaryTreeNode;
import org.junit.Test;
import utils.BoxingUtility;

import java.util.List;

import static org.junit.Assert.*;
import static utils.BinaryTreeUtility.*;

public class LongestIncreasingPathTest {

    @Test
    public void testLongestIncreasingSinglePath() throws Exception {
        BinaryTreeNode<Integer> tree1 = createTree(1);
        BinaryTreeNode<Integer> tree2 = createTree(1,2);
        BinaryTreeNode<Integer> tree3 = createTree(1,null,2);
        BinaryTreeNode<Integer> tree4 = createTree(1,2,null,3);
        BinaryTreeNode<Integer> tree5 = createTree(1,2,null,null,3);
        BinaryTreeNode<Integer> tree6 = createTree(1,null,3,null,null,4);
        BinaryTreeNode<Integer> tree7 = createTree(1,3,5);
        BinaryTreeNode<Integer> tree8 = createTree(0,2,4,null,3,5,null,
                                                    null,null,null,null,null,6);
        BinaryTreeNode<Integer> tree9 = createTree(1,3,null,null,4,null,null,
                                                    null,null,null,7);

        List<BinaryTreeNode<Integer>> list1 = LongestIncreasingPath.longestIncreasingSinglePath(tree1);
        List<BinaryTreeNode<Integer>> list2 = LongestIncreasingPath.longestIncreasingSinglePath(tree2);
        List<BinaryTreeNode<Integer>> list3 = LongestIncreasingPath.longestIncreasingSinglePath(tree3);
        List<BinaryTreeNode<Integer>> list4 = LongestIncreasingPath.longestIncreasingSinglePath(tree4);
        List<BinaryTreeNode<Integer>> list5 = LongestIncreasingPath.longestIncreasingSinglePath(tree5);
        List<BinaryTreeNode<Integer>> list6 = LongestIncreasingPath.longestIncreasingSinglePath(tree6);
        List<BinaryTreeNode<Integer>> list7 = LongestIncreasingPath.longestIncreasingSinglePath(tree7);
        List<BinaryTreeNode<Integer>> list8 = LongestIncreasingPath.longestIncreasingSinglePath(tree8);
        List<BinaryTreeNode<Integer>> list9 = LongestIncreasingPath.longestIncreasingSinglePath(tree9);

        List<Integer> unb1 = BoxingUtility.unboxAll(list1);
        List<Integer> unb2 = BoxingUtility.unboxAll(list2);
        List<Integer> unb3 = BoxingUtility.unboxAll(list3);
        List<Integer> unb4 = BoxingUtility.unboxAll(list4);
        List<Integer> unb5 = BoxingUtility.unboxAll(list5);
        List<Integer> unb6 = BoxingUtility.unboxAll(list6);
        List<Integer> unb7 = BoxingUtility.unboxAll(list7);
        List<Integer> unb8 = BoxingUtility.unboxAll(list8);
        List<Integer> unb9 = BoxingUtility.unboxAll(list9);

        assertArrayEquals(new Integer[]{1}, unb1.toArray());
        assertArrayEquals(new Integer[]{1,2}, unb2.toArray());
        assertArrayEquals(new Integer[]{1,2}, unb3.toArray());
        assertArrayEquals(new Integer[]{1,2,3}, unb4.toArray());
        assertArrayEquals(new Integer[]{1,2,3}, unb5.toArray());
        assertArrayEquals(new Integer[]{3,4}, unb6.toArray());
        assertArrayEquals(new Integer[]{3}, unb7.toArray());
        assertArrayEquals(new Integer[]{4,5,6}, unb8.toArray());
        assertArrayEquals(new Integer[]{3,4}, unb9.toArray());
    }
}