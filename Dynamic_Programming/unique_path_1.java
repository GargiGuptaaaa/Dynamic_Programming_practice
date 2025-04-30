public class unique_path_1 {
    public static void main(String[] args) {
        int m = 7;
        int n = 5;
        int[][] memo = new int[m + 1][n + 1];
        System.out.println(helper(m, n, memo));
    }

    public static  int helper(int m, int n, int[][] memo) {
        // base case
        if (m == 1 && n == 1)
            return 1;
        if (m == 0 || n == 0)
            return 0;

        // already computed
        if (memo[m][n] != 0)
            return memo[m][n];

        // compute and store in memo array
        // downways
        int down = helper(m - 1, n, memo);
        // rightways
        int right = helper(m, n - 1, memo);

        memo[m][n] = down + right;

        return memo[m][n];
    }
}
