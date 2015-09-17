package utils;

import model.BinaryTreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static utils.BinaryTreeUtility.*;
import static org.junit.Assert.*;

public class BinaryTreeUtilityTest {

//    @Test
    public void testCreateTreeFromList() {
        List<Integer> list1 = Arrays.asList(1);
        List<Integer> list2 = Arrays.asList(1,2,3);
        List<Integer> list3 = Arrays.asList(1,2,3,4,null,5,null);
        List<Integer> list4 = Arrays.asList(1,2,3,4,null,5,null,null,null,null,null,6);

        BinaryTreeNode<Integer> root1 = createTreeFromList(list1);
        BinaryTreeNode<Integer> root2 = createTreeFromList(list2);
        BinaryTreeNode<Integer> root3 = createTreeFromList(list3);
        BinaryTreeNode<Integer> root4 = createTreeFromList(list4);

        System.out.println(inOrderTraverse(root1));
        System.out.println(inOrderTraverse(root2));
        System.out.println(inOrderTraverse(root3));
        System.out.println(inOrderTraverse(root4));

        System.out.println(preOrderTraverse(root1));
        System.out.println(preOrderTraverse(root2));
        System.out.println(preOrderTraverse(root3));
        System.out.println(preOrderTraverse(root4));
    }
}