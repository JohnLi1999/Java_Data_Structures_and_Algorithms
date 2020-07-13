package Search_Algorithms;

public class Binary_Search {

    public static void main(String[] args) {
        int[] intArray = { -22, -15, 1, 7, 20, 35, 55 };

        System.out.println(iterativeBinarySearch(intArray, 1));
        System.out.println(iterativeBinarySearch(intArray, -22));
        System.out.println(iterativeBinarySearch(intArray, 55));
        System.out.println(iterativeBinarySearch(intArray, 7));
        System.out.println(iterativeBinarySearch(intArray, 8888));
        System.out.println(iterativeBinarySearch(intArray, 20));

        System.out.println();

        System.out.println(recursiveBinarySearch(intArray, 1));
        System.out.println(recursiveBinarySearch(intArray, -22));
        System.out.println(recursiveBinarySearch(intArray, 55));
        System.out.println(recursiveBinarySearch(intArray, 7));
        System.out.println(recursiveBinarySearch(intArray, 8888));
        System.out.println(recursiveBinarySearch(intArray, 20));
    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length; // end value will always be one larger than the partition we are looking at

        while (start < end) {
            int middle = (start + end) / 2;

            if (input[middle] == value) {
                return middle;
            } else if (input[middle] > value) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, value, 0, input.length);
    }

    private static int recursiveBinarySearch(int[] input, int value, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (input[middle] == value) {
            return middle;
        } else if (input[middle] > value) {
            return recursiveBinarySearch(input, value, start, middle);
        } else {
            return recursiveBinarySearch(input, value, middle + 1, end);
        }
    }
}
