
import java.util.*;

public class LeastCostProblem {

    public static int[] FindMin(int cost[][]) {
        int min = Integer.MAX_VALUE;
        int row = -1, col = -1;
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                if (cost[i][j] < min) {
                    min = cost[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new int[]{min, row, col};
    }

    public static void main(String[] args) {
        int cost[][] = {
            {12, 10, 12, 13},
            {7, 11, 8, 14},
            {6, 16, 11, 7}
        };

        int Demand[] = {180, 150, 350, 320};
        int Supply[] = {500, 300, 200};

        int Finalarr[][] = new int[Supply.length][Demand.length];

        int totalDemand = Arrays.stream(Demand).sum();
        int totalSupply = Arrays.stream(Supply).sum();

        int sum = 0;

        while (totalDemand > 0 && totalSupply > 0) {
            for (int i = 0; i < Supply.length; i++) {
                for (int j = 0; j < Demand.length; j++) {
                    int[] min_row_col = FindMin(cost);
                    int row = min_row_col[1];
                    int col = min_row_col[2];

                    if (Demand[col] < Supply[row]) {
                        Finalarr[row][col] = Demand[col];
                        sum += Demand[col] * cost[row][col];
                        Supply[row] -= Demand[col];
                        totalSupply -= Demand[col];
                        totalDemand -= Demand[col];
                        Demand[col] = 0;
                        for (int k = 0; k < cost.length; k++) {
                            cost[k][col] = Integer.MAX_VALUE;
                        }
                        i = Supply.length;
                        break;
                    } else if (Demand[col] > Supply[row]) {
                        Finalarr[row][col] = Supply[row];
                        sum += Supply[row] * cost[row][col];
                        Demand[col] -= Supply[row];
                        totalDemand -= Supply[row];
                        totalSupply -= Supply[row];
                        Supply[row] = 0;
                        for (int k = 0; k < cost[row].length; k++) {
                            cost[row][k] = Integer.MAX_VALUE;
                        }
                        i = Supply.length;
                        break;
                    } else {
                        Finalarr[row][col] = Demand[col];
                        sum += Demand[col] * cost[row][col];
                        totalDemand -= Demand[col];
                        totalSupply -= Supply[row];
                        Demand[col] = 0;
                        Supply[row] = 0;
                        for (int k = 0; k < cost[row].length; k++) {
                            cost[row][k] = Integer.MAX_VALUE;
                        }
                        for (int k = 0; k < cost.length; k++) {
                            cost[k][col] = Integer.MAX_VALUE;
                        }
                        i = Supply.length;
                        break;
                    }
                }
            }
        }

        System.out.println("Allocation Matrix:");
        for (int i = 0; i < Finalarr.length; i++) {
            System.out.println(Arrays.toString(Finalarr[i]));
        }
        System.out.println("Total cost is = " + sum);
    }
}
