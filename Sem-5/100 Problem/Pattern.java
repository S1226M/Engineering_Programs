public class Pattern {
    public static void main(String[] args) {
        int numberOfRows = 5;
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= (numberOfRows-(numberOfRows - i)); j++){
                System.out.print(j+" "); 
                System.out.print(" ");
            } 
            System.out.println(" ");
        }
    }
}
