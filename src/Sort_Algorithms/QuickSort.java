package Sort_Algorithms;

public class QuickSort {

    /*  Time Complexity: O(n*log(n))
        In-place Algorithm
        Unstable Sort
     */
    public static void quickSort(int[] arr, int start, int end) {
        /*  'end' is always one greater than the last valid index
            of the partition of you want to sort                   */

        // base case: when the length of the array is 1
        if ((end - start) < 2) { // in this case, (end - start) is the length of the partition (sub-array)
            return;
        }

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        /** this method uses the first element in the sub-array as the pivot **/
        int pivot = arr[start];
        int i = start;
        int j = end;

        // The gist is alternating between the end and start of the array
        while (i < j) {

            /*  loop from the end of the sub-array to the beginning until
                there is an element that is smaller than the pivot
                use --j because the end index is one larger than the last valid index in the sub-array and
                there will be values moved from the beginning of the array to index j                       */
            while((i < j) && (arr[--j] >= pivot)); // NOTE: empty loop body
            if (i < j) {
                arr[i] = arr[j]; // if i and j do not cross yet, move the value in index j to the beginning (at index i)
            }

            /*  loop from the beginning to the end until
                there is an element that is larger than the pivot
                use ++i because we use the initial start index as the pivot and
                there will be values moved from the end of the array to index i  */
            while ((i < j) && (arr[++i] <= pivot)); // NOTE: empty loop body
            if (i < j) {
                arr[j] = arr[i]; // if i and j do not cross yet, move the value in index i to the end (at index j)
            }

            /*  We will not lose any element since the value replaced by others is either
                assigned to a temporary variable (pivot value) or
                moved to its correct position in previous steps (when alternating i and j)
             */
        }

        // When i and j cross, the index will be the pivot index (both i and j can be pivot index, used j here)
        arr[j] = pivot; // assign the value of the pivot to the correct position
        return j; // return pivot index
    }
}
