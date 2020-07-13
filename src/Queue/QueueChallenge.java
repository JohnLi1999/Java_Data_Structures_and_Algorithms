package Queue;

import java.util.LinkedList;

public class QueueChallenge {

    public static void main(String[] args) {
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        String str = string.toLowerCase();

        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 'a' && c <= 'z') {
                stack.push(c);
                queue.add(c);  // queue.addLast(c);
            }
        }

        // Instructor's Way
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }

//        // My Way
//        while (!stack.isEmpty() && !queue.isEmpty()) {
//            char c1 = stack.pop();
//            char c2 = queue.remove();
//
//            if (c1 != c2) {
//                return false;
//            }
//        }

        return true;
    }
}
