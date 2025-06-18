import java.util.Scanner;

public class NorthWestCornerProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Row :");
        int row = sc.nextInt();
        System.out.print("Enter Col : ");
        int col = sc.nextInt();
        int cost[][] = new int[row][col];
        
        for(int i=0 ; i<row ; i++) {
            for(int j=0 ; j<col ; j++) {
                System.out.print("Enter cost for row " + (i+1) + " and col " + (j+1) + " : ");
                cost[i][j] = sc.nextInt();
            }
        }
        
        int Demand[] = new int[col]; 
        int Supply[] = new int[row];
        
        for(int i=0 ; i<col ; i++){
            System.out.print("Enter Demand for col " + (i+1) + " : ");
            Demand[i] = sc.nextInt();
        }

        for(int i=0 ; i<row ; i++){
            System.out.print("Enter Supply for row " + (i+1) + " : ");
            Supply[i] = sc.nextInt();
        }

        int Finalarr[][] = new int[Supply.length][Demand.length]; 
                
        for(int i=0 ; i<Supply.length ; i++){
            for(int j=0 ; j<Demand.length ; j++){
               if(Demand[j] < Supply[i]){
                Finalarr[i][j] = Demand[j];
                Supply[i] -= Demand[j];
                Demand[j] = 0;
               }
               else if(Demand[j] > Supply[i]){
                Finalarr[i][j] = Supply[i];
                Demand[j] -= Supply[i];
                Supply[i] = 0;
                break;
               }
               else{
                Finalarr[i][j] = Demand[j];
                Demand[j] = 0;
                Supply[i] = 0;
               }
            }
        }


        int sum = 0;
        for (int i = 0; i < Supply.length; i++) {
            for(int j=0 ; j < Demand.length ; j++){
                sum += Finalarr[i][j] * cost[i][j];
            }   
        }
        System.out.print("Total cost is =" + sum);
        System.out.print(sum);
    }    
}
