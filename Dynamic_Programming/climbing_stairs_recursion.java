public class climbing_stairs_recursion {
    public static void main(String[] args) {
        int n=2;
        //int [] memo = new int[n+1];
        System.out.println(climb(n));

    }
    public static int climb(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climb(n-1)+climb(n-2);
    }
}
