package Sort_Algorithms;

public class InsertionSort {

    /*  Time Complexity: O(n^2)
        In-place Algorithm
        Stable Sort
     */
    public static void insertionSort(int[] arr) {

        // return if the array has length of 0 or 1
        if (arr.length <= 1)
            return;

        // start inserting elements from index 1 (the second element in the array)
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int insertElement = arr[firstUnsortedIndex]; // save the element needs to be inserted

            int i;

            for (i = firstUnsortedIndex; (i > 0) && (arr[i - 1] > insertElement); i--) {
                // if we have not hit the first element (at index 0), and
                // the previous element is larger than the element needs to be inserted,
                // we shift the previous element to the right
                arr[i] = arr[i-1];
            }

            // the element will be inserted to index 0 if we hit the first element,
            // otherwise it will be inserted to the index which the previous element
            // is smaller or equal to itself
            arr[i] = insertElement;
        }
    }


    /* ---------------------------------------------------------------------------------- */

    // Insertion Sort in a recursive way
    public static void recursiveInsertionSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        recursiveHelper(arr, arr.length);
    }

    // Sort the first numItems of elements in the given array
    public static void recursiveHelper(int[] arr, int numItems) {
        if (numItems < 2) {
            return;
        }

        recursiveHelper(arr, numItems - 1);

        int insertElement = arr[numItems - 1];

        int i;

        for (i = numItems - 1; (i > 0 && arr[i-1] > insertElement); i--) {
            arr[i] = arr[i-1];
        }

        arr[i] = insertElement;
    }
}
