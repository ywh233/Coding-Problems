package problems.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Edwin on 15/10/5.
 */
public class WordBreakTest {

    @Test
    public void testWordBreak() throws Exception {

        assertFalse(WordBreak.wordBreak("aaaaaaa", createSet("aaaa","aa")));
    }

    private static <T> Set<T> createSet(T... obj) {
        return Arrays.asList(obj)
                .stream()
                .collect(Collectors.toSet());
    }
}