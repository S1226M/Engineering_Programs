import java.util.*;

public class DeletElementFromArrayAndShortThem_4_24 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size = sc.nextInt();
            int ar1[] = new int[size];
            
            for(int i=0 ; i<size ; i++){
                ar1[i] = sc.nextInt();
            }

            int Index = sc.nextInt();
            int ar2[] = new int[size-1];

            for(int i=0;i<(size-1);i++){
                if(i==Index){
                    ar2[i]=ar1[i+1];
                }
                else if(i<Index){
                    ar2[i]=ar1[i];
                }
                else if(i>Index){
                    ar2[i]=ar1[i+1];
                }
            }
            for(int i=0 ; i<(size-1) ; i++){
                System.out.print(" "+ar2[i]+" , ");
            }
            System.out.println(" ");
            int temp = 0;
            for(int i=0;i<=ar2.length;i++){
                for(int j=i;j<(ar2.length);j++){
                    if(ar2[i]>ar2[j]){
                        temp =ar2[i];
                        ar2[i] = ar2[j];
                        ar2[j] = temp;
                    }
                }
            }
            for(int i=0 ; i<(size-1) ; i++){
                System.out.print(" "+ar2[i]+" , ");
            }
        }
    }
}