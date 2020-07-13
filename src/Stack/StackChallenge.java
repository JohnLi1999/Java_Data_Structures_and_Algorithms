package Stack;

import java.util.LinkedList;

public class StackChallenge {

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
        StringBuilder strNoPunctuation = new StringBuilder(str.length());

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stack.push(c);
                strNoPunctuation.append(c);
            }
        }

        // My Way
        int i = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();

            if (c != strNoPunctuation.charAt(i++)) {
                return false;
            }
        }

        return true;

//        // Instructor's Way
//        StringBuilder reversedString = new StringBuilder(stack.size());
//        while (!stack.isEmpty()) {
//            reversedString.append(stack.pop());
//        }
//
//        return reversedString.toString().equals(strNoPunctuation.toString());
    }
}
