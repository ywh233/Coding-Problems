package utils;

import model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yuwei on 15/9/16.
 * Project: CodingProblems
 */
public class BinaryTreeUtility {
    public static <T> List<T> inOrderTraverse(BinaryTreeNode<T> node) {
        List<T> list = new ArrayList<>();
        inOrderTraverse(node, list);
        return list;
    }

    private static <T> void inOrderTraverse(BinaryTreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left, list);
        list.add(node.data);
        inOrderTraverse(node.right, list);
    }

    public static <T> List<T> preOrderTraverse(BinaryTreeNode<T> node) {
        List<T> list = new ArrayList<>();
        preOrderTraverse(node, list);
        return list;
    }

    private static <T> void preOrderTraverse(BinaryTreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        preOrderTraverse(node.left, list);
        preOrderTraverse(node.right, list);
    }

    // [1,   2, 3,   4, null, 5, null,   null, null, null, null, 6, null, null, null]
    public static <T> BinaryTreeNode<T> createTreeFromList(List<T> list) {
        Queue<BinaryTreeNode<T>> queue = new ArrayBlockingQueue<>(1024);
        BinaryTreeNode<T> terminator = new BinaryTreeNode<>(null, null, null);
        BinaryTreeNode<T> root = null;
        boolean isLeft = true;
        for (T data : list) {
            BinaryTreeNode<T> node = data == null? terminator: new BinaryTreeNode<>(data, null, null);
            if (root == null && node != terminator) {
                root = node;
            } else {
                BinaryTreeNode<T> parent = isLeft ? queue.peek() : queue.remove();

                if (node != terminator && parent != terminator) {
                    if (isLeft) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }

                isLeft = !isLeft;
            }

            queue.add(node);
        }
        return root;
    }

    @SafeVarargs
    public static <T> BinaryTreeNode<T> createTree(T... list) {
        return createTreeFromList(Arrays.asList(list));
    }
}
