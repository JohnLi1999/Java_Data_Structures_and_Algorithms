package HashTable;

public class Challenge_1 {

    public static void main(String[] args) {
        int[] nums = new int[10];
        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };

        for (int i = 0; i < numsToAdd.length; i++) {
            nums[hash(numsToAdd[i])] = numsToAdd[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Position " + i + ": " + nums[i]);
        }
    }

    public static int hash(int value) {
//        return Math.abs(value) / 10 % 10;
        return Math.abs(value % 10);
    }
}
