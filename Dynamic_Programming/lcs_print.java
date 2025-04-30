public class lcs_print {
    public static void main(String[] args) {
        String str1 = "acdbf";
        String str2 = "abdf";
        int n = str1.length();
        int m = str2.length();
        
        System.out.println(table(str1, str2, n, m));
    }
    public static String table(String str1, String str2, int n, int m) {
        StringBuilder sb = new StringBuilder();
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0;i <n+1;i++){
            dp[i][0]=0;

        }
         for(int j=0;j <m+1;j++){
            dp[0][j]=0;
            
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    sb.append(str1.charAt(i-1));
                    dp[i][j] = dp[i-1][j-1]+1;

                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    // max of decrease str1 decrese str2
                     dp[i][j]=  Math.max(ans1, ans2);
                }
            }
        }
        //return dp[n][m];
        return sb.toString();
       }
    
}
