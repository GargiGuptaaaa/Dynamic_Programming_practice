public class rod_cutting_tabulation {
    public static void main(String[] args) {
        int [] length = {1,2,3,4,5,6,7,8};
        int price [] = {1,4,8,9,10,17,20,20};
        int rodlength = 8;
        System.out.println(table(length , price , rodlength));

        
    }
    public static int table(int length[] , int price[] , int rodlength){
        int n= price.length;
        int dp[][] = new int [n+1][rodlength+1];
        // initialization
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }
        // table filling
        for(int i=1;i<n+1 ;i++){
            for(int j=1;j<rodlength+1;j++){
                // valid
                if(length[i-1] <= j){
                    // include
                    int include = price[i-1] + dp[i][j-length[i-1]];
                    // exclude
                    int exclude = dp[i-1][j];
                    dp[i][j]= Math.max(include , exclude);
                }
                // invalid 
                else{
                    // exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodlength];

    }
}
