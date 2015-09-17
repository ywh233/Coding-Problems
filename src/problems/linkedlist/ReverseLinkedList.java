package problems.linkedlist;

import model.LinkedListNode;

/**
 * Created by yuwei on 15/9/16.
 * Project: Playground
 */
public class ReverseLinkedList {
    public static <T> LinkedListNode<T> reverseLinkedListIterative(LinkedListNode<T> node) {
        LinkedListNode<T> newHead = null;

        while (node != null) {
            LinkedListNode<T> next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }

        return newHead;
    }

    public static <T> LinkedListNode<T> reverseLinkedListRecursive(LinkedListNode<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        LinkedListNode<T> oldNext = node.next;
        LinkedListNode<T> newNext = reverseLinkedListRecursive(oldNext);
        oldNext.next = node;
        node.next = null;
        return newNext;
    }
}
