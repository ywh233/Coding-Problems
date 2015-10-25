package problems.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Edwin on 15/10/5.
 */
public class PermutePalindrome {
    public static boolean canPermutePalindrome(String s) {
        Set<Character> singularChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (singularChars.contains(ch)) {
                singularChars.remove(ch);
            } else {
                singularChars.add(ch);
            }
        }
        return singularChars.isEmpty() || singularChars.size() == 1;
    }
}
