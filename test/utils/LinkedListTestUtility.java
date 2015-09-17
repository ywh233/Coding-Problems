package utils;

import model.LinkedListNode;

import static org.junit.Assert.assertTrue;
import static utils.LinkedListUtility.listEquals;
import static utils.LinkedListUtility.listToString;

/**
 * Created by yuwei on 15/9/16.
 * Project: Playground
 */
public class LinkedListTestUtility {
    public static <T> void assertLLEquals(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        assertTrue("L1=" + listToString(l1) + "; L2=" + listToString(l2),
                listEquals(l1, l2));
    }
}
