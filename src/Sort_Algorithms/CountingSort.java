package Sort_Algorithms;

public class CountingSort {

    /*  Time Complexity: O(n) - with assumption, such as only sort non-negative discrete values (e.g. integers)
        Not In-place Algorithm (requires extra memory)
        Unstable Sort, can be Stable Sort if using data structure like linked list instead of array
        Counting Sort works best when the range (number) of values you have is
        roughly equivalent to the number of values that you want to sort
     */
    public static void countingSort(int[] arr, int min, int max) {
        // create the count array according to the range of the values need to be sorted
        int[] countArray = new int[(max - min) + 1];

        // increase the number at the index that matches to the value in the input array
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        int j = 0;
        // traverse from the minimum value to the maximum value
        for (int i = min; i <= max; i++) {
            // if the corresponding index in the count array is not 0, copy the value to the original input array
            while (countArray[i - min] > 0) {
                arr[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
