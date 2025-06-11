import java.util.*;
// 3 Task
// 2 Server
public class Min_Time_To_Complete_3_Task {
    public static void main(String[] args) {
        int[] TaskTime = new int[]{10, 20, 30};
        int[] Server = new int[]{1, 2};
        int Server1 = 0;
        int Server2 = 0;

        
        ArrayList<String> result = new ArrayList();
        ArrayList<Integer> Finalresult = new ArrayList();
        
        for(int i=0 ; i<8 ; i++){
            String temp = String.format("%3s", Integer.toBinaryString(i)).replace(' ','0');
            result.add(temp);
        }
        System.out.println(result);
        int n = result.size();

        for(int j=0 ; j<n ; j++){
            for(int k = 0 ; k<3 ; k++){
                if (result.get(j).charAt(k) == '0') {
                    Server1 += TaskTime[k]; 
                }
                else{
                    Server2 += TaskTime[k];
                }
            }
            System.out.println(Server1);
            System.out.println(Server2);

            int max = Math.max(Server1, Server2);
            Finalresult.add(max);
            Server1 = 0;
            Server2 = 0;
        }
        System.out.println("Final "+Finalresult);

        int min = Finalresult.get(0);
        for(int i=1 ; i<Finalresult.size() ; i++){
            System.out.println(Finalresult);
        }
        for(int i=0 ; i<Finalresult.size() ; i++){
            if(Finalresult.get(i) <= min){
                min = Finalresult.get(i);
            }
        }
        System.out.println(min);
    }
}
