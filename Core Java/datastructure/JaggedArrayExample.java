package datastructure;

public class JaggedArrayExample {
    public static void main(String[] args) {
        // Creating a jagged array
        int[][] jaggedArr = new int[3][];
        jaggedArr[0] = new int[]{1, 2};
        jaggedArr[1] = new int[]{3, 4, 5};
        jaggedArr[2] = new int[]{6};

        // Printing Jagged Array
        for (int i = 0; i < jaggedArr.length; i++) {
            for (int j = 0; j < jaggedArr[i].length; j++) {
                System.out.print(jaggedArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
