package Sort_Algorithms;

public class ShellSort {

    /*  Time Complexity: O(n^2) for the worse case, but can perform much better than that
        In-place Algorithm
        Unstable Sort
     */
    public static void shellSort(int[] arr) {

        /*  1.  the outer most loop is kind of preliminary work
            2.  it uses a gap from the half length of the array to 1 as
                the insertion distance of an Insertion Sort, so that
                the elements in the array can be closer to the position
                they will finally be, which reduces the number of shifts
            3.  the final gap value will always be 1, which is exactly the same as an Insertion Sort
         */
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            // the inner two loops are similar to Insertion Sort
            // but the distance of comparing two elements is 'gap' instead of 1
            for (int i = gap; i < arr.length; i++) {
                int insertElement = arr[i];

                int j = i;

                while (j >= gap && arr[j - gap] > insertElement) {
                    // if we have not hit the element before index gap, and
                    // the previous gap distance element is larger than the element needs to be inserted,
                    // we shift the previous element gap distance to the right
                    arr[j] = arr[j - gap];
                    j -= gap; // then jump to check the element gap distance before
                }

                // put the element needs to be inserted at the right place
                arr[j] = insertElement;
            }
        }
    }
}
