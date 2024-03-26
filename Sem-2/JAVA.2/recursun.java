static int factorial(int n){
    if(n==0 || n==1){
        return 1;
    }
    else{
        return n * factorial(n-1);
    }
}
public class recursun {
    public static void main(String[] args) {
        System.out.println("fctorial of n is : "+factorial(6));
    }
}
