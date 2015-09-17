package problems.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuwei on 15/9/17.
 * Project: CodingProblems
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer count = charCount.get(ch);
            if (count == null) {
                count = 0;
            }
            count++;
            charCount.put(ch, count);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            Integer count = charCount.get(ch);
            if (count == null || count <= 0) {
                return false;
            }
            count--;
            charCount.put(ch, count);
        }
        return true;
    }
}
