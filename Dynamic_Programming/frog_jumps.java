public class frog_jumps {
    public static void main(String[] args) {
        int heights [] = {2,1,3,5,4};
        System.out.println(table(heights));
    }
    public static int table(int heights[]){
        int n = heights.length;
        int dp[] = new int[n];
        dp[0] =0;
        dp[1]  = Math.abs(heights[0]-heights[1]);
        for(int i=2;i<n;i++){
            // take one step 
            int ans1 = Math.abs(heights[i]-heights[i-1]) + dp[i-1];
            // take 2 step
            int ans2 = Math.abs(heights[i]-heights[i-2]) + dp[i-2];
            // find min power
            dp[i] = Math.min(ans1 , ans2);
        }
        return dp[n-1];

    }
}
