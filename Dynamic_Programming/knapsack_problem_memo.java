public class knapsack_problem_memo {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int n=wt.length;
        int W = 7; // weight of bag 
        int memo[][] = new int[n+1][W+1];
        
        System.out.println( kp(val,wt,n,W,memo));

    }
    public static int kp(int []val,int[] wt,int n ,int W,int memo[][]){
       
        if(W==0 || n==0){
            return 0;
        }
        if(memo[n-1][W]!=0){
            return memo[n-1][W];
        }

        if(W>=wt[n-1]){
            int include = val[n-1]+ kp(val,wt,n-1,W-wt[n-1],memo);
            int exclude = kp(val,wt,n-1,W,memo);
            return memo[n-1][W]= Math.max(include,exclude);
        }
        else{
            return memo[n-1][W]=kp(val,wt,n-1,W,memo);
        }
    }
}
// Time Complexity = O(n*W)