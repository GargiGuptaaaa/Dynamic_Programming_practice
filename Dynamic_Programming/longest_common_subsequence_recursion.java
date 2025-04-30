public class longest_common_subsequence_recursion {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length();
        System.out.println(recursion(str1, str2, n, m));
    }

    public static int recursion(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return recursion(str1, str2, n - 1, m - 1) + 1;
        } else {
            int ans1 = recursion(str1, str2, n - 1, m);
            int ans2 = recursion(str1, str2, n, m - 1);
            // decrease str1 + decrese str2
            return Math.max(ans1, ans2);

        }

    }
}
