package problems.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void testLongestPalindrome() throws Exception {
        assertEquals("a", LongestPalindrome.longestPalindrome("a"));
        assertEquals("a", LongestPalindrome.longestPalindrome("abcde"));
        assertEquals("aba", LongestPalindrome.longestPalindrome("aba"));
        assertEquals("abba", LongestPalindrome.longestPalindrome("abba"));
        assertEquals("ababa", LongestPalindrome.longestPalindrome("ababa"));
        assertEquals("aba", LongestPalindrome.longestPalindrome("ababc"));
        assertEquals("abba", LongestPalindrome.longestPalindrome("ababba"));
        assertEquals("babbab", LongestPalindrome.longestPalindrome("xbabbabc"));
    }
}