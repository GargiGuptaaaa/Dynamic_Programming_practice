public class matrix_chain_multiplication_memoization {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int i = 1;
        int j = arr.length - 1;
        int n = arr.length;
        int memo[][] = new int[n][n];
        for (int a = 0; a < memo.length; a++) {
            for (int b = 0; b < memo[0].length; b++) {
                memo[a][b] = -1;
            }
        }
        System.out.println(mcm(arr, memo, i, j));
        for (int a = 0; a < memo.length; a++) {
            for (int b = 0; b < memo[0].length; b++) {
                System.out.print(memo[a][b] +" ");
            }
            System.out.println();
        }

    }

    public static int mcm(int arr[], int memo[][], int i, int j) {
        if (i == j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcm(arr, memo, i, k);
            int cost2 = mcm(arr, memo, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int f_cost = cost1 + cost2 + cost3;
            ans = Math.min(f_cost, ans);

        }
        return memo[i][j] = ans;
    }
}
