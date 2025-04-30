public class coin_change_tabulation {
    public static void main(String[] args) {
        int   coin[] ={2,5,3,6};
        int sum = 10;
        System.out.println(table(coin , sum));

    }
    public static int table(int coin[], int sum){
        int n= coin.length;
        int dp[][] = new int[n+1][sum+1];
        // initialization 
        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }
        for(int j=1;j<sum+1 ;j++){
            dp[0][j] = 0;
        }
        // main filling of the table 
        // i =>  coin   , j => sum required at j th position
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1; j++){
                if(coin[i-1]<=j){
                    // include
                    int include = dp[i][j-coin[i-1]] ;

                    // exclude
                    int exclude = dp[i-1][j];

                    // total ways 
                    dp[i][j] = include + exclude;
                }
                else{
                    // exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];

    }
}
