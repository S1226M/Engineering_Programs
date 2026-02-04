import java.util.*;
public class Pattern {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int temp = 1;                       
        for(int i=0 ; i<=r ; i++){          
            for(int j=0 ; j<=c ; j++){     
                if(j<=i){   
                    if(j == 0){
                        System.out.print((i+temp)+" ");                     
                    }
                    else{
                        System.out.print((i + j + temp )+" ");            
                    }
                }
                else{
                    System.out.print(" ");                              
                }
                temp += 1;
            }
            System.out.println();
            temp = 1;
        }
        sc.close();
    }
}
