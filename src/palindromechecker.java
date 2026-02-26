import java.util.Stack;

public class palindromechecker{
    public static void main(String[] args) {
        String word = "madam";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        boolean isPalindrome = true;
        for (int i = 0; i < word.length(); i++) {
            char poppedChar = stack.pop();
            if (word.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The given string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + word + "\" is NOT a Palindrome.");
        }
    }
}