package datastructure;

public class BinarySearchExample {
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30};
        int key = 30;
        int index = binarySearch(arr, key);

        System.out.println((index != -1) ? "Element found at index: " + index : "Element not found");
    }
}
