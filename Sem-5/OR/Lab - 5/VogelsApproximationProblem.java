
import java.util.Arrays;

public class VogelsApproximationProblem {

    // Column Penalty Calculation
    public static int[] FindColPenalty(int cost[][]) {
        int m = cost.length;       // rows
        int n = cost[0].length;    // cols
        int[] costPenalty = new int[n];

        for (int col = 0; col < n; col++) {
            int[] temp = new int[m];
            for (int row = 0; row < m; row++) {
                temp[row] = cost[row][col];
            }
            Arrays.sort(temp);
            if (m >= 2) {
                costPenalty[col] = temp[1] - temp[0];
            } else {
                costPenalty[col] = temp[0];
            }
        }
        return costPenalty;
    }

    // Row Penalty Calculation
    public static int[] FindRowPenalty(int cost[][]) {
        int m = cost.length;
        int n = cost[0].length;
        int[] costPenalty = new int[m];

        for (int row = 0; row < m; row++) {
            int[] temp = new int[n];
            for (int col = 0; col < n; col++) {
                temp[col] = cost[row][col];
            }
            Arrays.sort(temp);
            if (n >= 2) {
                costPenalty[row] = temp[1] - temp[0];
            } else {
                costPenalty[row] = temp[0];
            }
        }
        return costPenalty;
    }

    public static Object[] FindPenalty(int cost[][], int Supply[], int Demand[]) {
        int[] penaltyCol = FindColPenalty(cost);
        int[] penaltyRow = FindRowPenalty(cost);

        return new Object[]{penaltyCol, penaltyRow};
    }

    public void FinalArr(int cost[][], int Supply[], int Demand[], int result[]) {

    }

    public static void main(String[] args) {
        int[][] cost = {
            {12, 10, 12, 13},
            {7, 11, 8, 14},
            {6, 16, 11, 7}
        };

        int[] Demand = {180, 150, 350, 320};
        int[] Supply = {500, 300, 200};

        Object[] penalties = FindPenalty(cost, Supply, Demand);

        // Type casting to retrieve the arrays
        int[] penaltyCol = (int[]) penalties[0];
        int[] penaltyRow = (int[]) penalties[1];

        System.out.println("Column Penalties: " + Arrays.toString(penaltyCol));
        System.out.println("Row Penalties   : " + Arrays.toString(penaltyRow));

        int[][] result = new int[2][];
        result[0] = penaltyRow;
        result[1] = penaltyCol;

    }
}
