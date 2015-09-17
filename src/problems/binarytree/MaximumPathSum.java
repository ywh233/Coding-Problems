package problems.binarytree;

import model.BinaryTreeNode;

/**
 * Created by yuwei on 15/9/16.
 * Project: CodingProblems
 */
public class MaximumPathSum {
    public static int maximumPathSum(BinaryTreeNode<Integer> root) {
        BestPathInfo info = findBestPathSum(root);
        return Math.max(info.innerBestSum, info.singleBestSum);
    }

    private static BestPathInfo findBestPathSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BestPathInfo(0, 0);
        }

        BestPathInfo leftInfo = findBestPathSum(root.left);
        BestPathInfo rightInfo = findBestPathSum(root.right);

        int innerSingleSum = leftInfo.singleBestSum + rightInfo.singleBestSum + root.data;
        int innerSum = Math.max(Math.max(leftInfo.innerBestSum, leftInfo.innerBestSum), innerSingleSum);
        int singleSum = Math.max(leftInfo.singleBestSum, rightInfo.singleBestSum) + root.data;
        return new BestPathInfo(innerSum, singleSum);
    }

    private static class BestPathInfo {
        public int innerBestSum, singleBestSum;

        public BestPathInfo(int innerBestSum, int singleBestSum) {
            this.innerBestSum = innerBestSum;
            this.singleBestSum = singleBestSum;
        }
    }
}
