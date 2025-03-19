package datastructure.sorting;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length-1;
        boolean swapped;

        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                   swapped = true;
                }
            }
            // If no swapping in inner loop, array is sorted

           if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
