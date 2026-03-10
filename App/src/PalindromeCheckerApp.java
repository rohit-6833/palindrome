import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeApp {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // Stack-Based Strategy
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            if (input == null || input.isEmpty()) return true;

            String processed = input.replaceAll("\\s+", "").toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (char ch : processed.toCharArray()) {
                stack.push(ch);
            }

            for (char ch : processed.toCharArray()) {
                if (ch != stack.pop()) return false;
            }
            return true;
        }
    }

    // Deque-Based Strategy
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            if (input == null || input.isEmpty()) return true;

            String processed = input.replaceAll("\\s+", "").toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();

            for (char ch : processed.toCharArray()) {
                deque.addLast(ch);
            }

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) return false;
            }
            return true;
        }
    }

    // Context Class
    static class PalindromeContext {
        private PalindromeStrategy strategy;

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean executeStrategy(String input) {
            return strategy.check(input);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("===== Strategy Pattern Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1 = Stack, 2 = Deque");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> context.setStrategy(new StackStrategy());
            case 2 -> context.setStrategy(new DequeStrategy());
            default -> {
                System.out.println("Invalid choice, defaulting to Stack strategy.");
                context.setStrategy(new StackStrategy());
            }
        }

        boolean result = context.executeStrategy(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}