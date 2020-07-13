package Search_Algorithms;

public class Linear_Search {

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        System.out.println(linearSearch(arr, -15));
        System.out.println(linearSearch(arr, 1));
        System.out.println(linearSearch(arr, 8888));
        System.out.println(linearSearch(arr, -22));
    }

    public static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }

        return -1; // return -1 if the specified element is not in the input array
    }
}
