package problems.linkedlist;

import model.LinkedListNode;
import org.junit.Test;

import java.util.function.Function;

import static utils.LinkedListTestUtility.assertLLEquals;
import static utils.LinkedListUtility.*;
import static org.junit.Assert.*;

public class ReverseLinkedListTest {
    @Test
    public void testReverseLinkedListIterative() {
        testReverseLinkedList(ReverseLinkedList::reverseLinkedListIterative);
    }

    @Test
    public void testReverseLinkedListRecursive() {
        testReverseLinkedList(ReverseLinkedList::reverseLinkedListRecursive);
    }

    private static void testReverseLinkedList
            (Function<LinkedListNode<Integer>, LinkedListNode<Integer>> reverseFn) {
        LinkedListNode<Integer> list1 = asLinkedList();
        LinkedListNode<Integer> list2 = asLinkedList(1);
        LinkedListNode<Integer> list3 = asLinkedList(1,2);
        LinkedListNode<Integer> list4 = asLinkedList(1,2,3);
        LinkedListNode<Integer> list5 = asLinkedList(1,2,3,4,5,6);

        list1 = reverseFn.apply(list1);
        list2 = reverseFn.apply(list2);
        list3 = reverseFn.apply(list3);
        list4 = reverseFn.apply(list4);
        list5 = reverseFn.apply(list5);

        LinkedListNode<Integer> list1Rev = asLinkedList();
        LinkedListNode<Integer> list2Rev = asLinkedList(1);
        LinkedListNode<Integer> list3Rev = asLinkedList(2,1);
        LinkedListNode<Integer> list4Rev = asLinkedList(3,2,1);
        LinkedListNode<Integer> list5Rev = asLinkedList(6,5,4,3,2,1);

        assertLLEquals(list1, list1Rev);
        assertLLEquals(list2, list2Rev);
        assertLLEquals(list3, list3Rev);
        assertLLEquals(list4, list4Rev);
        assertLLEquals(list5, list5Rev);
    }
}