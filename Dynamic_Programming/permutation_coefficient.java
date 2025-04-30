public class permutation_coefficient {
    public static void main(String[] args) {
        int n = 10;
        int r = 2 ;
        System.out.println(permutation(n,r));
    }
    public static int permutation(int n , int r){
        int dp[][] = new int[n+2][r+2];
        for(int j=0;j<r+1 ; j++){
            if(n==0){
                dp[0][r]=1;
            }
        }
        for(int i=1;i<n+1 ;i++){
            for(int j=0;j<r+1;j++){
                dp[i][j] = dp[i - 1][j] + 
                            (j * dp[i - 1][j - 1]); 
    
                dp[i][j + 1] = 0; 
            }


        }
        return dp[n][r]; 



    }

}
