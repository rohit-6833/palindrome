import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    static class PalindromeChecker {

        public boolean checkPalindrome(String input) {
            if (input == null || input.isEmpty()) {
                return true;
            }

            String processedInput = input.replaceAll("\\s+", "").toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < processedInput.length(); i++) {
                stack.push(processedInput.charAt(i));
            }

            for (int i = 0; i < processedInput.length(); i++) {
                if (processedInput.charAt(i) != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("===== Object-Oriented Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}