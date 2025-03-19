package datastructure.sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
//                System.out.println("i: "+i);
//                System.out.println("j: "+j);
//                System.out.println("minIndex: "+minIndex);
//                System.out.println("minValue:"+arr[minIndex]);
            }

//            for(int num : arr){
//                System.out.print(num+ " ");
//            }
//            System.out.println();
            // Swap elements
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
//            for(int num : arr){
//                System.out.print(num+ " ");
//            }
            //System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 5, 1};
        selectionSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
