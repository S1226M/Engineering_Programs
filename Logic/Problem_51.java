public class Problem_51 {
    public static void main(String[] args) {
        String s = "a!!!b.c.d,e'f,ghi";
        char arr[] = new char[s.length()];
        for(int i=0 ; i<s.length() ; i++){
            arr[i] = s.charAt(i);
        }

        int i=0;
        int j = s.length() - 1;
        while(i<j){
            if(!Character.isLetter(arr[i])){
                i++;
            }
            else if(!Character.isLetter(arr[j])){
                j--;
            }
            else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--; 
            }
        }
        System.out.println(String.valueOf(arr));
    }
}
