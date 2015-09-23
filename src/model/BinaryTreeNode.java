package model;

/**
 * Created by yuwei on 15/9/16.
 * Project: CodingProblems
 */
public class BinaryTreeNode<T> implements Unboxable<T> {
    public T data;
    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode() {}
    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public T unbox() {
        return data;
    }
}
