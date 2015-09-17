package problems.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShrinkSpaceTest {

    @Test
    public void testShrinkSpace() throws Exception {
        char[] c1 = new char[0];
        char[] c2 = "a".toCharArray();
        char[] c3 = "a b".toCharArray();
        char[] c4 = "a b c".toCharArray();
        char[] c5 = "a   b  c".toCharArray();
        char[] c6 = "a  b    c d".toCharArray();
    }
}