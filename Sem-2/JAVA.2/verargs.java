static int sum(int ...arr){
    int result=0;
    for(int a:arr){
        result +=a;
    }
    return result;
}
public class verargs{
    public static void main(String []args){
        System.out.println("sum of 0 parameter :"+sum());
        System.out.println("sum of 1 parameter :"+sum(10));
        System.out.println("sum of 2 parameters :"+sum(10,20));
        System.out.println("sum of 3 parameters :"+sum(10,20,30));
    }
}
