import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        System.out.println("===== Queue + Stack Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < processedInput.length(); i++) {
            char ch = processedInput.charAt(i);
            queue.add(ch);
            stack.push(ch);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

}