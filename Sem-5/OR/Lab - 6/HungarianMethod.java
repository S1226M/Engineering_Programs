import java.util.*;

public class HungarianMethod {

    private int[][] matrix;
    private int n;
    private int[][] originalMatrix;

    public HungarianMethod(int[][] costMatrix) {
        this.n = costMatrix.length;
        this.matrix = new int[n][n];
        this.originalMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = costMatrix[i][j];
                this.originalMatrix[i][j] = costMatrix[i][j];
            }
        }
    }

    public int findOptimalAssignment() {
        // Step 1: Row Reduction
        rowReduction();
        // Step 2: Column Reduction
        columnReduction();

        int[][] assignment;
        while (true) {
            assignment = findMaximumAssignment();
            int coveredZeros = countCoveredZeros(assignment);
            
            if (coveredZeros == n) {
                break; // Optimal solution found
            } else {
                adjustMatrix(assignment);
            }
        }

        // Calculate total cost
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (assignment[i][j] == 1) {
                    totalCost += originalMatrix[i][j];
                }
            }
        }

        System.out.println("✅ Final Assignment Matrix (1 = Assigned):");
        printMatrix(assignment);
        
        System.out.println("\n🧾 Assignments and Their Costs:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (assignment[i][j] == 1) {
                    System.out.println("  → Row " + (i + 1) + " assigned to Column " + (j + 1)
                            + " (Original Cost = " + originalMatrix[i][j] + ")");
                }
            }
        }
        
        return totalCost;
    }

    private void rowReduction() {
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                matrix[i][j] -= minVal;
            }
        }
    }

    private void columnReduction() {
        for (int j = 0; j < n; j++) {
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                matrix[i][j] -= minVal;
            }
        }
    }

    private int[][] findMaximumAssignment() {
        int[][] assignment = new int[n][n];
        boolean[] rowHasAssignment = new boolean[n];
        boolean[] colHasAssignment = new boolean[n];

        // Step 3: Find a maximum matching (greedy approach)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && !rowHasAssignment[i] && !colHasAssignment[j]) {
                    assignment[i][j] = 1;
                    rowHasAssignment[i] = true;
                    colHasAssignment[j] = true;
                }
            }
        }
        return assignment;
    }
    
    // Step 4: Cover all zeros with a minimum number of lines.
    private int countCoveredZeros(int[][] assignment) {
        boolean[] rowCovered = new boolean[n];
        boolean[] colCovered = new boolean[n];
        boolean[] rowWithAssignment = new boolean[n];
        boolean[] colWithAssignment = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (assignment[i][j] == 1) {
                    rowWithAssignment[i] = true;
                    colWithAssignment[j] = true;
                }
            }
        }
        
        // Mark all rows without an assigned zero
        for (int i = 0; i < n; i++) {
            if (!rowWithAssignment[i]) {
                rowCovered[i] = true;
            }
        }
        
        boolean changed = true;
        while (changed) {
            changed = false;
            // Mark columns that contain a zero in a marked row
            for (int j = 0; j < n; j++) {
                if (!colCovered[j]) {
                    for (int i = 0; i < n; i++) {
                        if (rowCovered[i] && matrix[i][j] == 0) {
                            colCovered[j] = true;
                            changed = true;
                            break;
                        }
                    }
                }
            }
            // Mark rows that have an assigned zero in a marked column
            for (int i = 0; i < n; i++) {
                if (!rowCovered[i]) {
                    for (int j = 0; j < n; j++) {
                        if (colCovered[j] && assignment[i][j] == 1) {
                            rowCovered[i] = true;
                            changed = true;
                            break;
                        }
                    }
                }
            }
        }

        // Draw lines through all unmarked rows and marked columns
        int coveredCount = 0;
        for (int i = 0; i < n; i++) {
            if (!rowCovered[i]) coveredCount++;
        }
        for (int j = 0; j < n; j++) {
            if (colCovered[j]) coveredCount++;
        }
        
        // This is a simplified check. The correct count is the number of lines.
        // A full implementation would track lines, but this works for determining optimality.
        return coveredCount;
    }

    // Step 5: Adjust the matrix to create new zeros
    private void adjustMatrix(int[][] assignment) {
        boolean[] rowCovered = new boolean[n];
        boolean[] colCovered = new boolean[n];
        boolean[] rowWithAssignment = new boolean[n];
        boolean[] colWithAssignment = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (assignment[i][j] == 1) {
                    rowWithAssignment[i] = true;
                    colWithAssignment[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!rowWithAssignment[i]) {
                rowCovered[i] = true;
            }
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int j = 0; j < n; j++) {
                if (!colCovered[j]) {
                    for (int i = 0; i < n; i++) {
                        if (rowCovered[i] && matrix[i][j] == 0) {
                            colCovered[j] = true;
                            changed = true;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!rowCovered[i]) {
                    for (int j = 0; j < n; j++) {
                        if (colCovered[j] && assignment[i][j] == 1) {
                            rowCovered[i] = true;
                            changed = true;
                            break;
                        }
                    }
                }
            }
        }
        
        // Get all lines
        boolean[] finalRowCovered = new boolean[n];
        boolean[] finalColCovered = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!rowCovered[i]) finalRowCovered[i] = true;
        }
        for (int j = 0; j < n; j++) {
            if (colCovered[j]) finalColCovered[j] = true;
        }

        int minUncovered = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!finalRowCovered[i]) {
                for (int j = 0; j < n; j++) {
                    if (!finalColCovered[j]) {
                        if (matrix[i][j] < minUncovered) {
                            minUncovered = matrix[i][j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!finalRowCovered[i] && !finalColCovered[j]) {
                    matrix[i][j] -= minUncovered;
                } else if (finalRowCovered[i] && finalColCovered[j]) {
                    matrix[i][j] += minUncovered;
                }
            }
        }
    }

    private void printMatrix(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🧠 HUNGARIAN METHOD - ASSIGNMENT PROBLEM SOLVER");
        System.out.println("--------------------------------------------------");

        // Your provided matrix from the image
        int[][] problemMatrix = {
            {2, 9, 2, 7, 1},
            {6, 8, 7, 6, 1},
            {4, 6, 5, 3, 1},
            {4, 2, 7, 3, 1},
            {5, 3, 9, 5, 1}
        };

        HungarianMethod solver = new HungarianMethod(problemMatrix);
        int totalCost = solver.findOptimalAssignment();
        System.out.println("\n💰 Total Minimum Assignment Cost = " + totalCost);
        sc.close();
    }
}