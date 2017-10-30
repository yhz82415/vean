package dp;

import java.util.ArrayList;
import java.util.List;

public class MinCostPath {
    public static void main(String... args) {
        int[][] input = new int[][]{{1, 3, 5, 8},
                                    {4, 2, 1, 7},
                                    {4, 3, 2, 3}};
        findPath(input);
    }

    private static void findPath(int [][] matrix) {
        int[][] auxMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    auxMatrix[i][j] = matrix[i][j];
                } else if (i == 0 && j > 0) {
                    auxMatrix[i][j] = auxMatrix[i][j-1] + matrix[i][j];
                } else if (i > 0 && j == 0) {
                    auxMatrix[i][j] = auxMatrix[i-1][j] + matrix[i][j];
                } else  if (i > 0 && j > 0) {
                    auxMatrix[i][j] = Math.min(auxMatrix[i-1][j], auxMatrix[i][j-1]) + matrix[i][j];
                }
            }
        }
        System.out.println("Minimum cost: " + auxMatrix[matrix.length - 1][matrix[0].length - 1]);
        // TODO ... ...
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        List<String> paths = new ArrayList<>();
        paths.add(String.valueOf(matrix[row][col]));
        for (int i = row; i >=0; i--) {
            for (int j = col; j >= 0; j--) {
                if (i == 0 && j != 0) {
                    paths.add(String.valueOf(matrix[i][j - 1]));
                } else if (j == 0 && i != 0) {
                    paths.add(String.valueOf(matrix[i - 1][j]));
                } else if (i == 0 && j == 0) {
                    paths.add(String.valueOf(matrix[i][j]));
                } else {
                    int prev = auxMatrix[i][j] - matrix[i][j];
                    paths.add(String.valueOf(auxMatrix[i][j-1] == prev ? matrix[i][j-1] : matrix[i-1][j]));
                }
            }
        }
        System.out.println("Minimum path: " + paths);
    }
}
