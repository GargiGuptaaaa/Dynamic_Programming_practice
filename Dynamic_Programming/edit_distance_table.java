public class edit_distance_table {
    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(table(str1, str2));

    }

    public static int table(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;

        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;

        }
        // initalization
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // insert
                    int insert = dp[i][j - 1] + 1;
                    // replace
                    int replace = dp[i - 1][j - 1] + 1;
                    // remove
                    int remove = dp[i - 1][j] + 1;
                    // min
                    dp[i][j] = Math.min(insert, Math.min(replace, remove));
                }
            }
        }
        return dp[n][m];
    }
}
