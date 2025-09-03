import java.util.*;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. of Process");
        int n = sc.nextInt();
        int AT[] = new int[n];
        int BT[] = new int[n];
        int CT[] = new int[n];
        int TAT[] = new int[n];
        int WT[] = new int[n];

        for(int i=0 ; i<n ; i++){
            System.out.println("Enter the AT value at Po. "+i);
            AT[i] = sc.nextInt();
            System.out.println("Enter the BT value at Po. "+i);
            BT[i] = sc.nextInt();
        }
        Arrays.sort(BT);
        for(int i=0 ; i<n ; i++){
            if(i==0){
                CT[i] = AT[i] + BT[i];
            }
            else{
                CT[i] = BT[i] + CT[i-1];
            }
            TAT[i] = CT[i] - AT[i];
            WT[i] = TAT[i] - BT[i];
        }


        System.out.println("BT\t"+"CT\t"+"TAT\t"+"WT\t");
        for(int i=0 ; i<2 ; i++){
            System.out.println(BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
        for(int i=2 ; i<n ; i++){
            System.out.println(BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
    }    
}