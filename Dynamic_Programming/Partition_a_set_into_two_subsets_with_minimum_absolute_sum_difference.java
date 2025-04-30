import java.util.ArrayList;
public class Partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference {
    public static void main(String[] args) {
        int nums [] = {3,9,7,3};
        int target = 0;
        for(int i=0;i<nums.length;i++){
            target +=nums[i];
        }
        System.out.println(subset_sum(nums , target));
    }
    public static int subset_sum(int nums[] , int target){
        int n = nums.length;
        boolean dp [][] = new boolean [n+1][target+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<target+1;j++){
            dp[0][j] = false;
        }
        // fill up the table 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(nums[i-1]<=j){
                    boolean ans1 = dp[i-1][j-nums[i-1]];
                    boolean ans2 = dp[i-1][j];
                    dp[i][j] = ans1 || ans2;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        ArrayList < Integer> list = new ArrayList<>();
        for(int j=0;j<target+1;j++){
            if(dp[n][j]){
                list.add(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size()/2 ;i++){
            min = Math.min(min , target - 2*list.get(i));
        }
        return min;
    }
}
