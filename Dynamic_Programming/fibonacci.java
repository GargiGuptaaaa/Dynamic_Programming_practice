public class fibonacci {
    public static void main(String[] args) {
        int n = 7;
        int f[] = new int[n+1];
        System.out.println(fib(n,f));
    }

    public static int fib(int n,int f[]) {
        if (n == 0) {
            return 0;

        }
        if (n == 1) {
            return 1;
        }
        if(f[n]!=0){
            return f[n];
        }
        return f[n]=fib(n - 1,f) + fib(n - 2,f);
    }
}