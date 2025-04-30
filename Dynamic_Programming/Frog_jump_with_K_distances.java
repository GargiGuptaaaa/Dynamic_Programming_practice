public class Frog_jump_with_K_distances {
    public static void main(String[] args) {
        int heights [] = {15, 4, 1, 14, 15};
        int k=3;
        System.out.println(table(heights , k));
        
    }
    public static int table(int heights[]  , int k ){
        
        int n= heights.length;
        int dp[] = new int[n+1];
        if(n==0){
            return 0;
        }
        dp[0]=0;
       //  base cases
        for(int i=1;i<k;i++){
            int min_cost = Integer.MAX_VALUE;
            for(int j=1;j<=i;j++){
                int ans1 = Math.abs(heights[i] - heights[i-j]) + dp[i-j];
                min_cost = Math.min(ans1 , min_cost);
            }
            dp[i] = min_cost;
        }

        // main table fill 

        for(int i=k;i<n;i++){
            int min_cost = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                int ans1 = Math.abs(heights[i] - heights[i-j]) + dp[i-j];
                min_cost = Math.min(ans1 , min_cost);
            }
            dp[i] = min_cost;
        }
        return dp[n-1];
    }

}
