package problems.dp;

/**
 * Created by Edwin on 15/10/5.
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        int[] p = new int[n + 1];
        p[0] = 0;

        for (int i = 1; i <= n; i++) {
            int leastSquares = -1;
            for (int j = 0; j < i; j++) {
                double square = Math.sqrt(i - j);
                if (square == ((int) square) && p[j] > -1) {
                    if (leastSquares == -1 || p[j] + 1 < leastSquares) {
                        leastSquares = p[j] + 1;
                    }
                }
            }
            p[i] = leastSquares;
        }
        return p[n];
    }
}
