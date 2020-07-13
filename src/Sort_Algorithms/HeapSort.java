package Sort_Algorithms;

import Heap.Heap;

public class HeapSort {

    public static void heapSort(int[] arr) {
        // Check the sort() method in Heap
        // the following is not the real algorithm for Heap Sort

        Heap heap = new Heap(arr.length);
        for (int value : arr) {
            heap.insert(value);
        }

        heap.sort();

        int[] sortedArr = heap.toArray();
        System.arraycopy(sortedArr, 0, arr, 0, arr.length);
    }
}
