public class climbing_stair_memo {
    public static void main(String[] args) {
        int n = 7;
        int[] memo = new int[n + 1];
        System.out.println(climb(n, memo));

    }

    public static int climb(int n, int[] memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
    }
}
