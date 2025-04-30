public class minimum_no_of_coins_requered_to_make_amount {
    public static void main(String[] args) {
        int coins[] ={1,2,5};
        int amount = 11;
        int n = coins.length;
        System.out.println(table(coins , amount));
       
        
    }
    public static int table(int coins[] , int amount){
        int n = coins.length;
        int dp[][] = new int [n][amount+1];
        
        for(int j=0 ;j<amount+1 ;j++){
            if(j%coins[0]==0){
                dp[0][j] =j / coins[0];
            }
            else{
                dp[0][j] = (int)1e9;
            }
        }
        // fill up the remaining table
        for(int i=1;i<n ; i++){
            for(int j=0;j<amount+1;j++){
               
                    int notTake = 0 + dp[i-1][j];
                    // valid
                    int take = Integer.MAX_VALUE;
                 if(coins[i] <=j){
                    take = 1+dp[i][j-coins[i]];
                    
                 } 
                    dp[i][j] = Math.min(take ,notTake);
                    
                
                
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<amount+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();

        }
       return dp[n - 1][amount] >= 1e9 ? -1 : dp[n - 1][amount];

    }

}
