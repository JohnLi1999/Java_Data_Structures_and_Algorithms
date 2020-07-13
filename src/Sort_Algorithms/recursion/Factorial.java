package Sort_Algorithms.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(recursiveFactorial(6));
        System.out.println(iterativeFactorial(6));
    }

    /*
        1! = 1 = 1 * 0!
        2! = 2 * 1 = 2 * 1!
        3! = 3 * 2 * 1 = 3 * 2!
        4! = 4 * 3 * 2 * 1 = 4 * 3!
        5! = 5 * 4 * 3 * 2 * 1 = 5 * 4!
        ...
        n! = n * (n - 1) * ... * 2 * 1 = n * (n - 1)!
     */

    public static int recursiveFactorial(int num) {
        if (num <= 1) {
            return 1;
        }

        return num * recursiveFactorial(num - 1);
    }

    public static int iterativeFactorial(int num) {
        if (num <= 1) {
            return 1;
        }

        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
