import java.util.*;

public class palindromechecker{
    public static boolean twoPointerCheck(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean stackCheck(String word) {
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
    public static boolean recursiveCheck(String word, int start, int end) {
        if (start >= end) return true;
        if (word.charAt(start) != word.charAt(end)) return false;
        return recursiveCheck(word, start + 1, end - 1);
    }
    public static void main(String[] args) {
        String input = "racecar";
        long startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;
        startTime = System.nanoTime();
        boolean result2 = stackCheck(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;
        startTime = System.nanoTime();
        boolean result3 = recursiveCheck(input, 0, input.length() - 1);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;
        System.out.println("Palindrome Check Results:");
        System.out.println("-------------------------------------");
        System.out.println("Two-Pointer Result: " + result1 + " | Time: " + twoPointerTime + " ns");
        System.out.println("Stack-Based Result: " + result2 + " | Time: " + stackTime + " ns");
        System.out.println("Recursive Result: " + result3 + " | Time: " + recursiveTime + " ns");
    }
}