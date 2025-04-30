public class minimum_insertion_to_make_string_palindrome {
    public static void main(String[] args) {
        String s = "bbbab";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(s.length()-lcs(s ,sb.toString()));
    }
    public static int lcs(String str1 , String str2){
        int n= str1.length();
        int m= str2.length();
        int dp[][] = new int[n+1][m+1];
        // base case 
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;

        }
         for(int i=0;i<n+1;i++){
            dp[0][i] = 0;
            
        }
        // fill the table
        for(int i=1;i<n+1 ;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];

                }
                else{
                    // str1 decrease
                    int ans1 = dp[i-1][j];
                    // str2 decrease
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1 , ans2);
                }
            }
        }
        return dp[n][m];

    }
}
