package Sort_Algorithms;

public class BubbleSort {

    /*  Time Complexity: O(n^2)
        In-place Algorithm
        Stable Sort
     */
    public static void bubbleSort(int[] arr) {

        // return if the array has length of 0 or 1
        if (arr.length <= 1)
            return;

        // for each round, put the largest element to the last index in the array
        for(int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                // swap the elements if the number in lower index is larger than the number in higher index
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

    }
}
