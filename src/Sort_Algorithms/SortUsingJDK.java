package Sort_Algorithms;

import java.util.Arrays;

public class SortUsingJDK {

    public static void main(String[] args) {
        System.out.println("Arrays.sort()");
        int[] arr1 = createArr();
        Arrays.sort(arr1);
        printArr(arr1);

        System.out.println("Arrays.parallelSort()");
        int[] arr2 = createArr();
        Arrays.parallelSort(arr2);
        printArr(arr2);
    }

    public static int[] createArr() {
        return new int[]{-5, 5, -100, -1, 250, 0, 2, 1000, 3, -100};
    }

    public static void printArr(int[] arr) {
        System.out.print("[ ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("]\n");
    }
}
