package datastructure;

public class ArrayExample {
    public static void main(String[] args) {
        // Declare & initialize an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Access elements using index
        System.out.println("First Element: " + numbers[0]); // 10

        // Loop through the array using for-each loop
        System.out.print("Array Elements: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
