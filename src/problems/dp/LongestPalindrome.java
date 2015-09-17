package problems.dp;

/**
 * Created by yuwei on 15/9/16.
 * Project: CodingProblems
 */
public class LongestPalindrome {
    public static String longestPalindrome(String str) {
        boolean[][] isPal = new boolean[str.length()][str.length()];

        int longestCount = -1;
        int longestI = -1;
        int longestJ = -1;

        for (int windowSize = 0; windowSize < str.length(); windowSize++) {
            int j;
            for (int i = 0; (j = i + windowSize) < str.length(); i++) {
                isPal[i][j] = (i == j) ||
                        (str.charAt(i) == str.charAt(j)
                        && ((i == j-1) || (isPal[i+1][j-1])));
                if (isPal[i][j] && windowSize > longestCount) {
                    longestCount = windowSize;
                    longestI = i;
                    longestJ = j;
                }
            }
        }

        if (longestCount > -1) {
            return str.substring(longestI, longestJ + 1);
        } else {
            return null;
        }
    }
}
