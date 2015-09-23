package model;

/**
 * Created by yuwei on 15/9/16.
 * Project: Playground
 */
public class LinkedListNode<T> implements Unboxable<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public T unbox() {
        return data;
    }
}
