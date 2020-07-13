package Sort_Algorithms;

public class SelectionSort {

    /*  Time Complexity: O(n^2)
        In-place Algorithm
        Unstable Sort
     */
    public static void selectSort(int[] arr) {

        // return if the array has length of 0 or 1
        if (arr.length <= 1)
            return;

        // Method 1: sorts the array from left to right (min to max)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // assume the first index in each turn has the minimum value

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }


//        // Method 2: sorts the array from right to left (max to min)
//        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
//            int largest = 0; // assume the largest index is at index 0;
//
//            for (int i = 1; i <= lastUnsortedIndex; i++) {
//                if (arr[i] > arr[largest]) {
//                    largest = i;
//                }
//            }
//
//            // swap
//            int temp = arr[lastUnsortedIndex];
//            arr[lastUnsortedIndex] = arr[largest];
//            arr[largest] = temp;
//        }
    }
}
