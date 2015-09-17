package utils;

import model.LinkedListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuwei on 15/9/16.
 * Project: Playground
 */
public class LinkedListUtility {
    public static <T> LinkedListNode<T> listToLinkedList(List<T> list) {
        LinkedListNode<T> head = null;
        LinkedListNode<T> current = null;
        for (T data : list) {
            LinkedListNode<T> newNode = new LinkedListNode<>(data, null);
            if (head == null) {
                head = newNode;
            }
            if (current != null) {
                current.next = newNode;
            }

            current = newNode;
        }
        return head;
    }

    public static String listToString(LinkedListNode<?> node) {
        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.data).append("->");
            node = node.next;
        }

        sb.append("(NULL)");
        return sb.toString();
    }

    @SafeVarargs
    public static <T> LinkedListNode<T> asLinkedList(T... args) {
        List<T> list = Arrays.asList(args);
        return listToLinkedList(list);
    }

    public static <T> boolean listEquals(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        if (l1 == null && l2 == null) {
            return true;
        } else if (l1 == null || l2 == null) {
            return false;
        }
        while (l1.next != null && l2.next != null) {
            if (l1.data != l2.data) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1.next == null && l2.next == null;
    }

    public static int count(LinkedListNode<?> node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public static <T> LinkedListNode<T> seek(LinkedListNode<T> node, int pos) {
        if (pos < 0) {
            return null;
        }
        while (node != null && pos > 0) {
            node = node.next;
            pos--;
        }
        return node;
    }
}
