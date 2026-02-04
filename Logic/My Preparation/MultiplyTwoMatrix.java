public class MultiplyTwoMatrix {
    public static void main(String[] args) {

        int arr1[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int arr2[][] = {
                { 7, 8 },
                { 9, 10 },
                { 11, 12 }
        };

        int ans[][] = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) { // rows of arr1
            for (int j = 0; j < arr2[0].length; j++) { // columns of arr2
                for (int k = 0; k < arr1[0].length; k++) { // columns of arr1
                    ans[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        // Print result
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
