package problems.linkedlist;

import model.LinkedListNode;
import static utils.LinkedListUtility.*;

/**
 * Created by yuwei on 15/9/16.
 * Project: Playground
 */
public class LinkedListPalindrome {
    // Will not modify the list
    public static <T> boolean isPalindrome(LinkedListNode<T> node) {
        if (node == null) {
            return false;
        }
        int length = count(node);

        int half = length / 2;

        LinkedListNode<T> latter = seek(node, half);
        LinkedListNode<T> latterRev = ReverseLinkedList.reverseLinkedListIterative(latter);

        boolean isPal = isBeginWith(node, latterRev, half);

        ReverseLinkedList.reverseLinkedListIterative(latterRev);

        return isPal;
    }

    private static boolean isBeginWith(LinkedListNode<?> begin, LinkedListNode<?> list, int len) {
        while (len > 0 && list != null) {
            if (begin.data != list.data) {
                return false;
            }
            begin = begin.next;
            list = list.next;
            len--;
        }
        return len == 0;
    }
}
