package utils;

import model.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;
import static utils.LinkedListUtility.*;

public class LinkedListUtilityTest {

    @Test
    public void testListEquals() throws Exception {
        LinkedListNode<Integer> list1 = asLinkedList();
        LinkedListNode<Integer> list2 = asLinkedList(1);
        LinkedListNode<Integer> list3 = asLinkedList(1,2);
        LinkedListNode<Integer> list4 = asLinkedList(1,2,3);

        LinkedListNode<Integer> list1p = asLinkedList();
        LinkedListNode<Integer> list2p = asLinkedList(1);
        LinkedListNode<Integer> list3p = asLinkedList(1,2);
        LinkedListNode<Integer> list4p = asLinkedList(1,2,3);

        assertTrue(listEquals(list1, list1p));
        assertTrue(listEquals(list2, list2p));
        assertTrue(listEquals(list3, list3p));
        assertTrue(listEquals(list4, list4p));

        assertFalse(listEquals(list1, list2));
        assertFalse(listEquals(list2, list3));
        assertFalse(listEquals(list3, list4));
    }

    @Test
    public void testListToString() {
        LinkedListNode<Integer> list1 = asLinkedList();
        LinkedListNode<Integer> list2 = asLinkedList(1);
        LinkedListNode<Integer> list3 = asLinkedList(1,2);
        LinkedListNode<Integer> list4 = asLinkedList(1,2,3);

        assertEquals("(NULL)", listToString(list1));
        assertEquals("1->(NULL)", listToString(list2));
        assertEquals("1->2->(NULL)", listToString(list3));
        assertEquals("1->2->3->(NULL)", listToString(list4));
    }

    @Test
    public void testListCount() {
        LinkedListNode<Integer> list1 = asLinkedList();
        LinkedListNode<Integer> list2 = asLinkedList(1);
        LinkedListNode<Integer> list3 = asLinkedList(1,2);
        LinkedListNode<Integer> list4 = asLinkedList(1,2,3);

        assertEquals(0, count(list1));
        assertEquals(1, count(list2));
        assertEquals(2, count(list3));
        assertEquals(3, count(list4));
    }

    @Test
    public void testSeek() {
        LinkedListNode<Integer> list = asLinkedList(0,1,2,3,4,5,6,7);

        assertTrue(0 == seek(list, 0).data);
        assertTrue(1 == seek(list, 1).data);
        assertTrue(7 == seek(list, 7).data);
        assertNull(seek(list, 8));
        assertNull(seek(list, -1));
    }
}