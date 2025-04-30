public class decode_ways_without_zero {
    public static void main(String[] args) {
        String str = "12123";
        System.out.println(table(str));
    }

    public static int table(String str) {
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i - 2));
            sb.append(str.charAt(i - 1));
            if (Integer.parseInt(sb.toString()) <= 26) {
                dp[i] = dp[i - 1] + 1;

            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[n];
    }
}
