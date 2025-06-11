public class Max_Value_OF_Z{
    public static void main(String[] args) {
        int z = 0;
        int ans = 0;
        int x1 = 0;
        int x2 = 0;
        for(int i=0 ; i<=4 ; i++){
            for(int j=0 ; j<=4 ; j++){
                if((i+j)<=4){
                    z = (3*i)+(2*j);
                    if(ans <= z){
                        ans = z;
                        x2 = j;
                        x1 = i;
                    }
                }
            }
        }
        System.out.println("Max VAlue Of Z = "+ans);
        System.out.println("Max Value of x1 = "+x1);
        System.out.println("Max Value of x2 = "+x2);
    }
}