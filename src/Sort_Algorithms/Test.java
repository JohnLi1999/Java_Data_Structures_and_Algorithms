package Sort_Algorithms;

import java.util.Arrays;

public class Test {

    private static int[] arr;
    private static String[] strArr;

    public static void main(String[] args) {
        System.out.println("Sort Algorithm without Assumptions \n");

        System.out.println("JDK Collection Sort - just for comparison");
        arr = createArr();
        Arrays.sort(arr);
        printArr(arr);

        System.out.println("Bubble Sort");
        arr = createArr();
        BubbleSort.bubbleSort(arr);
        printArr(arr);

        System.out.println("Selection Sort");
        arr = createArr();
        SelectionSort.selectSort(arr);
        printArr(arr);

        System.out.println("Insertion Sort");
        arr = createArr();
        InsertionSort.insertionSort(arr);
        printArr(arr);

        System.out.println("Recursive Insertion Sort");
        arr = createArr();
        InsertionSort.recursiveInsertionSort(arr);
        printArr(arr);

        System.out.println("Shell Sort");
        arr = createArr();
        ShellSort.shellSort(arr);
        printArr(arr);

        System.out.println("Merge Sort");
        arr = createArr();
        MergeSort.mergeSort(arr, 0, arr.length);
        printArr(arr);

        System.out.println("Reverse Merge Sort - Descending Order");
        arr = createArr();
        MergeSort.reverseMergeSort(arr, 0, arr.length);
        printArr(arr);

        System.out.println("Quick Sort");
        arr = createArr();
        QuickSort.quickSort(arr, 0, arr.length);
        printArr(arr);

        System.out.println("Heap Sort");
        arr = createArr();
        HeapSort.heapSort(arr);
        printArr(arr);

        System.out.println("--------------------------------------------------------------\n");

        System.out.println("Sort Algorithm with Assumptions\n");

        System.out.println("JDK Collection Sort - just for comparison");
        arr = createNonNegativeIntArr();
        Arrays.sort(arr);
        printArr(arr);

        System.out.println("Counting Sort");
        arr = createNonNegativeIntArr();
        CountingSort.countingSort(arr, 0, 10);
        printArr(arr);

        System.out.println("JDK Collection Sort - just for comparison");
        arr = createRadixIntArr();
        Arrays.sort(arr);
        printArr(arr);

        System.out.println("Radix Sort");
        arr = createRadixIntArr();
        RadixSort.radixSort(arr, 10, 4);
        printArr(arr);

        System.out.println("JDK Collection Sort - just for comparison");
        strArr = createRadixLowercaseStringArr();
        Arrays.sort(strArr);
        printArr(strArr);

        System.out.println("Radix String Sort");
        strArr = createRadixLowercaseStringArr();
        RadixSort.radixSort(strArr, 26, 5);
        printArr(strArr);

        System.out.println("JDK Collection Sort - just for comparison");
        arr = createBucketArr();
        Arrays.sort(arr);
        printArr(arr);

        System.out.println("Bucket Sort");
        arr = createBucketArr();
        BucketSort.bucketSort(arr);
        printArr(arr);
    }

    public static int[] createArr() {
        return new int[]{-5, 5, -100, -1, 250, 0, 2, 1000, 3, -100};
    }

    public static int[] createNonNegativeIntArr() { return new int[]{2, 5, 9, 8, 2, 0, 8, 7, 10, 4, 3}; }

    public static int[] createRadixIntArr() { return new int[]{4725, 4586, 1330, 8792, 1594, 5729}; }

    public static int[] createBucketArr() { return new int[]{54, 46, 83, 66, 95, 92, 43}; }

    public static String[] createRadixLowercaseStringArr() { return new String[]{"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"}; }

    public static void printArr(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]\n");
    }

    public static void printArr(String[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]\n");
    }
}
