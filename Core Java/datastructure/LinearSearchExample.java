package datastructure;

public class LinearSearchExample {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Return index of found element
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 10, 20, 35};
        int key = 10;
        int index = linearSearch(arr, key);

        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");
    }
}
