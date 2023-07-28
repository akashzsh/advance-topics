import java.util.Arrays;

// Memoization

public class Problem01 {
  static int calculate(int n, int[] dp) {
    if (n <= 1)
      return n;
    if (dp[n] != -1)
      return dp[n];
    dp[n] = calculate(n - 1, dp) + calculate(n - 2, dp);
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 9;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    int ans = calculate(n, dp);
    System.out.println(ans);
  }
}

// Tabulation
/*
 * public class Problem01 {
 * public static void main(String[] args) {
 * int n = 8;
 * int[] dp = new int[n + 1];
 * dp[0] = 0;
 * dp[1] = 1;
 * for (int i = 2; i <= n; i++) {
 * dp[i] = dp[i - 1] + dp[i - 2];
 * }
 * System.out.println(dp[n]);
 * }
 * }
 */

// Tabulation with Space Optimization
/*
 * public class Problem01 {
 * public static void main(String[] args) {
 * int n = 8;
 * int prev1 = 0, prev2 = 1, curr = 1;
 * for (int i = 2; i <= n; i++) {
 * curr = prev1 + prev2;
 * prev1 = prev2;
 * prev2 = curr;
 * }
 * System.out.println(prev2);
 * }
 * }
 */
