package Heap;

import java.util.NoSuchElementException;

public class Heap {

    private int[] heap; // this class implements a max heap, which has the largest value at the top
    private int size; // "size" is always points to the next available position

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is Full");
        }

        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is Empty");
        }

        return heap[0];
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is Empty");
        }

        if (index < 0 || index >= size) {
            throw new NoSuchElementException("No such element in the heap");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1]; // put the rightmost element into the deleted position
        size--;

        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        return deletedValue;
    }

    /*  Time Complexity: O(n*log(n))
        In-place Algorithm
        Unstable Sort
     */
    public void sort() {
        int lastHeapIndex = size - 1;

        for (int i = lastHeapIndex; i > 0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            fixHeapBelow(0, i - 1);
        }
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];

        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);

            if (leftChild <= lastHeapIndex) {
                if (rightChild <= lastHeapIndex) {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                } else {
                    childToSwap = leftChild;
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;

                    index = childToSwap;
                } else {
                    break;
                }

            } else {
                break;
            }
        }
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChild(int index) {
        return 2 * index + 1;
    }

    public int getRightChild(int index) {
        return 2 * index + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int[] toArray() {
        int[] arr = new int[heap.length];
        System.arraycopy(heap, 0, arr, 0, heap.length);
        return arr;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
