public class Num_Roman {
    
    // Arrays to store Roman numeral symbols and their corresponding values
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    // Method to convert an integer to a Roman numeral
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // Iterate through the VALUES array
        while (num > 0) {
            // Subtract the largest possible value and append its corresponding symbol
            while (num >= VALUES[i]) {
                num -= VALUES[i];
                sb.append(SYMBOLS[i]);
            }
            i++;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int number = 1; // Change this to the desired integer
        String romanNumeral = intToRoman(number);
        System.out.println("Roman numeral for " + number + " is: " + romanNumeral);
    }
}