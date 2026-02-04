import java.util.Scanner;

public class Problem_28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String n = sc.nextLine();
        
        char arr[] = new char[n.length()];
        for(int i=0 ; i<n.length() ; i++){
            arr[i] = n.charAt(i);
        }

        int i=1;
        String ans = "";
        while(i<arr.length){
            if(!Character.isLetter(arr[i])){
                for(int j=1 ; j<arr[i] ; j++){
                    ans += arr[i];
                }
                i++;
            }
            i++;
        } 
        System.out.println(ans);
    }    
}
