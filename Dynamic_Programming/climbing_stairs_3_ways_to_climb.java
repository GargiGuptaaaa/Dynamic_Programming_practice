public class climbing_stairs_3_ways_to_climb {
    public static void main(String[] args) {
        int n=4;
        //int [] memo = new int[n+1];
        System.out.println(climb(n));

    }
    public static int climb(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }if(n<2){
            return n;
        }
        if(n==3){
            return 4;
        }
        return climb(n-1)+climb(n-2)+climb(n-3);
    }
}
