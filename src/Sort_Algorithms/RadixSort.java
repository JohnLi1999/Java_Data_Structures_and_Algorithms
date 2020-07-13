package Sort_Algorithms;

public class RadixSort {

    /*  Time Complexity: O(n) - with assumptions: data must have the same radix and width
        Can be In-place Algorithm, depends on which sort algorithm you use
        Stable Sort
     */
    /*  Explanation of Radix and Width
        Radix:
            binary number: radix = 2 since there are only two values (0 and 1)
            decimal number: radix = 10 since there are ten values (0 - 9)
            alphabet: radix = 26 since there are 26 letters (a - z)
        Width:
            100: width = 3 since there are 3 digits
            hello: width = 5 since there are 5 letters
     */
    public static void radixSort(int[] arr, int radix, int width) {
        // loop all the digits of the values in the array
        for (int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix); // each time sort the array by the specific digit
        }
    }

    public static void radixSingleSort(int[] arr, int position, int radix) {
        int numItems = arr.length;
        int[] countArray = new int[radix];

        // create the count array
        for (int value : arr) {
            countArray[getDigit(position, value, radix)]++;
        }

        /*  adjust the count array so that each position has the number of values
            that have that digit or less than that digit in the position that is working with  */
        for (int i = 1; i < radix; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Stable Count Sort - Preserving the Ordering of Duplicate values
        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] = arr[tempIndex];
        }

        // copy the value in the temporary array into the input array
        System.arraycopy(temp, 0, arr, 0, numItems);
    }

    /**
     * Get the digit at the specified position in the value by the given radix
     *
     * @param position the specified position
     * @param value    the value
     * @param radix    the radix of the value
     * @return         the digit at the position in the value
     */
    public static int getDigit(int position, int value, int radix) {
        return (value / (int) Math.pow(radix, position)) % radix;
    }


    /* ---------------------------------------------------------------------------------- */

    // Radix Sort for Strings with only lowercase letters
    public static void radixSort(String[] arr, int radix, int width) {
        // loop all the letters of the Strings in the array
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(arr, i, radix); // each time sort the array by the specific digit
        }
    }

    public static void radixSingleSort(String[] arr, int position, int radix) {
        int numItems = arr.length;
        int[] countArray = new int[radix];

        // create the count array
        for (String str : arr) {
            countArray[getIndex(position, str)]++;
        }

        /*  adjust the count array so that each position has the number of values
            that have the char or before that char in the position that is working with  */
        for (int i = 1; i < radix; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Stable Count Sort - Preserving the Ordering of Duplicate values
        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, arr[tempIndex])]] = arr[tempIndex];
        }

        // copy the value in the temporary array into the input array
        System.arraycopy(temp, 0, arr, 0, numItems);
    }

    public static int getIndex(int position, String str) {
        return str.charAt(position) - 'a';
    }
}
