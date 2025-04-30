public class catalan_number_memo {
    public static void main(String[] args) {
        int n=4;
        int memo[] = new int[n+1];
        System.out.println(catalan(n,memo));
    }
    public static int catalan(int n,int memo[]){
        if(n==0||n==1){
            return 1;
        }
        if(memo[n]!=0){
            return memo[n];
        }

        int ans =0;
        for(int i=0;i<n;i++){
            ans += catalan(i,memo) * catalan(n-i-1,memo);
        }
        return memo[n]=ans;
    }
}
