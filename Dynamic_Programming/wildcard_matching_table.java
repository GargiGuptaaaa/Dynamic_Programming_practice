public class wildcard_matching_table {
    public static void main(String[] args) {
        String string = "cb";
        String pattern = "?a";
        System.out.println(table(string, pattern));

    }

    public static boolean table(String string, String pattern) {
        int n = string.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        // if both are empty string
        dp[0][0] = true;

        // initialization conditions

        // if pattern is empty
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // if string is empty
        for (int j = 1; j < m + 1; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        // filling the table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (string.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    // ignore the star
                    boolean ans1 = dp[i][j - 1];

                    // include the sequence of star
                    boolean ans2 = dp[i - 1][j];
                    dp[i][j] = ans1 || ans2;
                    // dp[i][j] = dp[i][j-1]||dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];

    }
}
