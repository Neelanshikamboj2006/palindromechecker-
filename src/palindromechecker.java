import java.util.*;
interface PalindromeStrategy {
    boolean checkPalindrome(String word);
}
class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
class PalindromeService {
    private PalindromeStrategy strategy;
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean execute(String word) {
        return strategy.checkPalindrome(word);
    }
}
public class palindromechecker{
    public static void main(String[] args) {
        String input = "madam";
        PalindromeStrategy strategy = new StackStrategy();
        PalindromeService service = new PalindromeService(strategy);
        boolean result = service.execute(input);
        if (result) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}