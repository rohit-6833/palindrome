import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeApp {

    // Stack-based approach
    private static boolean stackPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : processed.toCharArray()) stack.push(ch);
        for (char ch : processed.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }

    // Deque-based approach
    private static boolean dequePalindrome(String input) {
        if (input == null || input.isEmpty()) return true;
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : processed.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }

    // Recursive approach
    private static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }

    // Simple two-pointer approach (case-insensitive, space-ignored)
    private static boolean simplePalindrome(String input) {
        if (input == null || input.isEmpty()) return true;
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = processed.length() - 1;
        while (start < end) if (processed.charAt(start++) != processed.charAt(end--)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Palindrome Performance Comparison =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        long start, end;

        start = System.nanoTime();
        boolean resultStack = stackPalindrome(input);
        end = System.nanoTime();
        System.out.println("Stack approach: " + resultStack + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean resultDeque = dequePalindrome(input);
        end = System.nanoTime();
        System.out.println("Deque approach: " + resultDeque + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean resultRecursive = recursivePalindrome(processed, 0, processed.length() - 1);
        end = System.nanoTime();
        System.out.println("Recursive approach: " + resultRecursive + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean resultSimple = simplePalindrome(input);
        end = System.nanoTime();
        System.out.println("Simple two-pointer approach: " + resultSimple + " | Time: " + (end - start) + " ns");

        scanner.close();
    }
}