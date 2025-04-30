public class longest_common_subsequence_memo {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length();
        int memo[][] = new int [n+1][m+1];
        System.out.println(recursion(str1, str2, n, m,memo));
        
    }
    public static int recursion(String str1, String str2, int n, int m,int[][] memo) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if(memo[n][m] !=0){
            return memo[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return memo[n][m]=recursion(str1, str2, n - 1, m - 1,memo) + 1;
        } else {
            int ans1 = recursion(str1, str2, n - 1, m,memo);
            int ans2 = recursion(str1, str2, n, m - 1,memo);
            // decrease str1 + decrese str2
            return memo[n][m]= Math.max(ans1, ans2);

        }

    }

}
