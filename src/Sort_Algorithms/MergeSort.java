package Sort_Algorithms;

public class MergeSort {

    /*  Time Complexity: O(n*log(n))
        Not In-place Algorithm (requires extra memory)
        Stable Sort
     */
    public static void mergeSort(int[] arr, int start, int end) {
        /*  'end' is always one greater than the last valid index
            of the partition of you want to sort                   */

        // base case: when the length of the array is 1
        if ((end - start) < 2) { // in this case, (end - start) is the length of the partition (sub-array)
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid); // not include element at index mid in the left sub-array
        mergeSort(arr, mid, end); // include the element at index mid in the right sub-array array
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {

        /*  If the last element of the left partition is less than or equal to
            the first element in the right partition, it means all the elements
            in the left partition are less than or equal to the elements in the
            right partition because both left and right partition are sorted     */
        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0; // index for tracking the temp array

        int[] temp = new int[end - start]; // (end - start) is the length of the partition (sub-array)
        while (i < mid && j < end) {
            temp[tempIndex++] = (arr[i] <= arr[j] ? arr[i++] : arr[j++]);

//            // the same as the one line of code above
//            if (arr[i] <= arr[j]) {
//                temp[tempIndex] = arr[i];
//                tempIndex++;
//                i++;
//            } else {
//                temp[tempIndex] = arr[j];
//                tempIndex++;
//                j++;
//            }
        }

        /*  If we have elements left in the left partition, then we need to copy them
            to the end of the original array since they will be moved to different positions.
            However if we have elements left in the right partition, then we do not need to
            do anything because they will be moved to their original positions.
            So, we do not do anything when there are elements left in the right partition       */

        /* copy the elements after index i in the left partition to the correct position in the original array,
           the length of the partition to copy is (mid - 1) since after the while loop index i will start at
           the index where the first element needs to be copied. If there is no element in the left
           partition is left, mid is equal to i and the length is 0. So, no element will be copied. If the
           length is 1, then just the first element (at index i) is copied.                                     */

        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);

        /*  The final step is to copy all the elements in the temporary array to the original array,
            we only need to copy the elements up to tempIndex since the rest part in the array
            is handled in the previous step                                                          */
        System.arraycopy(temp, 0, arr, start, tempIndex);

//        // the same as the two lines of code above
//        int c = tempIndex, d = tempIndex;
//        for (int a = i; a < mid; a++, c++) {
//            arr[start + c] = arr[a];
//        }
//        for (int b = 0; b < d; b++, start++) {
//            arr[start] = temp[b];
//        }
    }


    /* ---------------------------------------------------------------------------------- */

    /*  Sort the array in descending order  */
    public static void reverseMergeSort(int[] arr, int start, int end) {
        if ((end - start) < 2) {
            return;
        }

        int mid = (end + start) / 2;
        reverseMergeSort(arr, start, mid);
        reverseMergeSort(arr, mid, end);
        reverseMerge(arr, start, mid, end);
    }

    public static void reverseMerge(int[] arr, int start, int mid, int end) {
        if (arr[mid-1] >= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = (arr[i] >= arr[j] ? arr[i++] : arr[j++]);
        }

        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);

        System.arraycopy(temp, 0, arr, start, tempIndex);
    }
}
