public class knapsack_problem {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int n=wt.length;
        int W = 7; // weight of bag 
        
        System.out.println( kp(val,wt,n,W));

    }
    public static int kp(int []val,int[] wt,int n ,int W){
       
        if(W==0 || n==0){
            return 0;
        }

        if(W>=wt[n-1]){
            int include = val[n-1]+ kp(val,wt,n-1,W-wt[n-1]);
            int exclude = kp(val,wt,n-1,W);
            return Math.max(include,exclude);
        }
        else{
            return kp(val,wt,n-1,W);
        }
    }
}
