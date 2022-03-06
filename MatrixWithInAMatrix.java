package Answer1;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixWithInAMatrix {
    public static void main(String[] args) {
        int n = 10, m = 40;
        Scanner s = new Scanner(System.in);
        int[][] smallMatrix = new int[n][n];
        int[][] bigMatrix = new int[m][m];
        System.out.println("Populate small matrix now:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter a number => ");
                smallMatrix[i][j] = s.nextInt();
            }
        }
        System.out.println("Big matrix now:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Enter a number => ");
                bigMatrix[i][j] = s.nextInt();
            }
        }

        boolean isIn = false;

        for (int i = 0; i < m && !isIn; i++) {
            for (int j = 0; j < m && !isIn; j++) {
                isIn = isInBigMatrix(smallMatrix,bigMatrix,i,j);
            }
        }
        if(isIn){
            System.out.println("The small matrix is in the big one");
        }
        else
            System.out.println("The small matrix is NOT in the big one");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(smallMatrix[i]));
        }
        System.out.println("-------------");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(bigMatrix[i]));
        }

    }

    public static boolean isInBigMatrix(int[][] matrix, int[][] bigMatrix, int startRow, int starCol){
        if (matrix.length > bigMatrix.length - startRow)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != bigMatrix[i + startRow][j+starCol])
                    return false;
            }
        }
        return true;

    }
}
