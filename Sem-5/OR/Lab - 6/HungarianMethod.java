
import java.util.*;

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

    public static void AssignmentArr(int[][] assignment, int[][] arr, int[][] copyarr) {
        int n = arr.length;
        boolean[] rowAssigned = new boolean[n];
        boolean[] colAssigned = new boolean[n];
        List<Integer> skippedRows = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            int zeroCol = -1;

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && !colAssigned[j]) {
                    zeroCount++;
                    zeroCol = j;
                }
            }

            if (zeroCount == 1 && !colAssigned[zeroCol]) {
                assignment[i][zeroCol] = 1;
                rowAssigned[i] = true;
                colAssigned[zeroCol] = true;
            } else {
                skippedRows.add(i);
            }
        }

        for (int i : skippedRows) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && !colAssigned[j]) {
                    assignment[i][j] = 1;
                    rowAssigned[i] = true;
                    colAssigned[j] = true;
                    break;
                }
            }
        }

        System.out.println("\n✅ Final Assignment Matrix (1 = Assigned):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(assignment[i][j] + " ");
            }
            System.out.println();
        }

        int totalCost = 0;
        System.out.println("\n🧾 Assignments and Their Costs:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (assignment[i][j] == 1) {
                    System.out.println(" → Row " + (i + 1) + " assigned to Column " + (j + 1)
                            + " (Original Cost = " + copyarr[i][j] + ")");
                    totalCost += copyarr[i][j];
                }
            }
        }

        System.out.println("\n💰 Total Minimum Assignment Cost = " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🧠 HUNGARIAN METHOD - ASSIGNMENT PROBLEM SOLVER");
        System.out.println("--------------------------------------------------");

        System.out.print("Enter number of tasks/workers (Matrix size NxN): ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        int[][] copyarr = new int[n][n];

        System.out.println("\n📥 Enter the cost matrix (Cost[i][j] = Cost to assign Row i to Column j):");

        for (int i = 0; i < n; i++) {
            System.out.println("Enter costs for Row " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.print("  → Cost at position [" + (i + 1) + "][" + (j + 1) + "]: ");
                arr[i][j] = sc.nextInt();
                copyarr[i][j] = arr[i][j]; // backup
            }
        }

        System.out.println("\n📌 Step 1: Row Reduction (Subtract min of each row)");
        int[] rowMins = FindMinFromRow(arr);
        RowReduction(arr, rowMins);

        System.out.println("\n📌 Step 2: Column Reduction (Subtract min of each column)");
        int[] colMin = FindMinFromColumn(arr);
        ColumnReduction(arr, colMin);

        int[][] assignment = new int[n][n];
        AssignmentArr(assignment, arr, copyarr);

        sc.close();
    }
}
