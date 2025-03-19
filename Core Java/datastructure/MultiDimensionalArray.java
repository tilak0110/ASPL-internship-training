package datastructure;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        // Declare a 2D array
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Print the 2D array
        System.out.println("2D Array Elements:");
        for (int i = 0; i < matrix.length; i++) {  // Iterating rows
            for (int j = 0; j < matrix[i].length; j++) {  // Iterating columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
