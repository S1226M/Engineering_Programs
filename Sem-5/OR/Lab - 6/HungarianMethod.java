
public class HungarianMethod {

    public static int[] FindMinFromRow(int[][] arr) {
        int[] minValues = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
            minValues[i] = min;
            System.out.print(min + " ");
        }
        System.out.println();
        return minValues;
    }

    public static void RowReduction(int[][] arr, int[] rowMins) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] -= rowMins[i];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] FindMinFromColumn(int[][] arr) {
        int[] minValues = new int[arr[0].length];

        for (int j = 0; j < arr[0].length; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
            minValues[j] = min;
            System.out.print(min + " ");
        }
        System.out.println();
        return minValues;
    }

    public static void ColumnReduction(int[][] arr, int[] colMin) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] -= colMin[j];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void AssignmentArr(int Assignment[][], int arr[][]) {

    }

    public static void main(String[] args) {
        int[][] arr = {
            {15, 13, 14, 17},
            {11, 12, 15, 13},
            {13, 12, 10, 11},
            {15, 17, 14, 16}
        };

        System.out.println("Min Value In Each Row");
        int[] rowMins = FindMinFromRow(arr);

        System.out.println("After Row Reduction");
        RowReduction(arr, rowMins);

        System.out.println("Min Value In Each Column");
        int[] colMin = FindMinFromColumn(arr);

        System.out.println("After Column Reduction");
        ColumnReduction(arr, colMin);

        int Assignment[][] = new int[arr.length][arr[0].length];

    }
}
