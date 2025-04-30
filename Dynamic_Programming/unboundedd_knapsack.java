import javax.sound.midi.Sequencer.SyncMode;

public class unboundedd_knapsack {
    public static void main(String[] args) {
        int val[] = {15,14,10,35,30};
        int wt[] = {2,5,1,3,4};
        int n=wt.length;
        int W = 7;
        System.out.println(table(val,wt,n-1,W));
        
    }
    public static int table(int val[], int wt[],int n,int W){
        int dp[][]= new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<W+1;j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(j>=wt[i-1]){
                    //include
                    int include = val[i-1]+dp[i][j-wt[i-1]] ;

                    // exclue
                    int exclude = dp[i-1][j];
                    dp[i][j]= Math.max(include ,exclude);
                }
                else{
                    // exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}
