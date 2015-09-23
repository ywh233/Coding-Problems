package problems.binarytree;

import model.BinaryTreeNode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuwei on 15/9/18.
 * Project: CodingProblems
 */
public class LongestIncreasingPath {
    public static List<BinaryTreeNode<Integer>>
    longestIncreasingSinglePath(BinaryTreeNode<Integer> root) {
        FindISPResult result = findLongestIncreasingPath(root);
        Collections.reverse(result.longestGlobalPath);
        return result.longestGlobalPath;
    }

    private static FindISPResult
    findLongestIncreasingPath(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new FindISPResult(null, null);
        }

        FindISPResult leftResult = findLongestIncreasingPath(root.left);
        FindISPResult rightResult = findLongestIncreasingPath(root.right);

        if (leftResult.longestPathWithRoot != null && leftResult.longestPathWithRoot.peek().data.equals(root.data + 1)) {
            leftResult.longestPathWithRoot.push(root);
        } else {
            leftResult.longestPathWithRoot = null;
        }

        if (rightResult.longestPathWithRoot != null && rightResult.longestPathWithRoot.peek().data.equals(root.data + 1)) {
            rightResult.longestPathWithRoot.push(root);
        } else {
            rightResult.longestPathWithRoot = null;
        }

        Stack<BinaryTreeNode<Integer>> longestPathWithRoot = getLongestCollection(leftResult.longestPathWithRoot, rightResult.longestPathWithRoot);
        if (longestPathWithRoot == null) {
            longestPathWithRoot = new Stack<>();
            longestPathWithRoot.push(root);
        }

        Stack<BinaryTreeNode<Integer>> longestGlobalPath = getLongestCollection(leftResult.longestGlobalPath, rightResult.longestGlobalPath, longestPathWithRoot);
        return new FindISPResult(longestGlobalPath, longestPathWithRoot);
    }

    public static List<BinaryTreeNode<Integer>> longestIncreasingPathV(BinaryTreeNode<Integer> root) {
        return null;
    }

    private static <T extends Collection<?>> T getLongestCollection(T... collections) {
        T best = null;
        for (T collection : collections) {
            if (best == null) {
                best = collection;
                continue;
            }
            if (collection != null && collection.size() > best.size()) {
                best = collection;
            }
        }
        return best;
    }

    private static class FindISPResult {
        Stack<BinaryTreeNode<Integer>> longestGlobalPath;
        Stack<BinaryTreeNode<Integer>> longestPathWithRoot;

        public FindISPResult(Stack<BinaryTreeNode<Integer>> lgp, Stack<BinaryTreeNode<Integer>> lpr) {
            longestGlobalPath = lgp;
            longestPathWithRoot = lpr;
        }
    }
}
