public class target_sum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 7, 3};
        int sum = 6;
        System.out.println(target(arr, sum));
    }

    public static boolean target(int arr[], int target) {
        boolean dp[][] = new boolean[arr.length+1][target+1];
        for(int i=0;i<arr.length+1;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<target+1;j++){
            dp[0][j] = false;
        }
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<target+1;j++){
                if(arr[i-1]<=j ){
                   
                    
                     dp[i][j] =  dp[i - 1][j - arr[i - 1]]||  dp[i - 1][j];




                   
                }
                else {
                   
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[arr.length][target];

    }
}