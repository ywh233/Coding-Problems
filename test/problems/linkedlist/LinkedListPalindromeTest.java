package problems.linkedlist;

import model.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;
import static utils.LinkedListUtility.*;
import static utils.LinkedListTestUtility.*;

public class LinkedListPalindromeTest {
    @Test
    public void testIsPalindrome() {
        LinkedListNode<Integer> list1 = asLinkedList();
        LinkedListNode<Integer> list2 = asLinkedList(1);
        LinkedListNode<Integer> list3 = asLinkedList(1,2);
        LinkedListNode<Integer> list4 = asLinkedList(1,2,1);
        LinkedListNode<Integer> list5 = asLinkedList(1,2,2,1);
        LinkedListNode<Integer> list6 = asLinkedList(1,2,3,1);
        LinkedListNode<Integer> list7 = asLinkedList(1,2,3,4);

        assertTrue(LinkedListPalindrome.isPalindrome(list2));
        assertTrue(LinkedListPalindrome.isPalindrome(list4));
        assertTrue(LinkedListPalindrome.isPalindrome(list5));

        assertFalse(LinkedListPalindrome.isPalindrome(list1));
        assertFalse(LinkedListPalindrome.isPalindrome(list3));
        assertFalse(LinkedListPalindrome.isPalindrome(list6));
        assertFalse(LinkedListPalindrome.isPalindrome(list7));

        // assert list not modified
        assertLLEquals(list2, asLinkedList(1));
        assertLLEquals(list3, asLinkedList(1,2));
        assertLLEquals(list4, asLinkedList(1,2,1));
        assertLLEquals(list5, asLinkedList(1,2,2,1));
        assertLLEquals(list6, asLinkedList(1,2,3,1));
        assertLLEquals(list7, asLinkedList(1,2,3,4));
    }
}