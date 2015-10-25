package problems.dp;

import java.util.Set;

/**
 * Created by Edwin on 15/10/5.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int begin = i - word.length() + 1;
                if (begin < 0) {
                    continue;
                }
                if ((begin == 0 || breakable[begin - 1]) && stringMatches(s, begin, i+1, word)) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length() - 1];
    }

    private static boolean stringMatches(String str, int begin, int end, String patt) {
        int j = 0;
        for (int i = begin; i < end; i++) {
            if (j >= patt.length() || str.charAt(i) != patt.charAt(j)) {
                return false;
            }
            j++;
        }
        return j == patt.length();
    }
}
