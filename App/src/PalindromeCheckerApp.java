import java.util.Scanner;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String originalString = scanner.nextLine();

        boolean result = isPalindromeUsingStack(originalString);

        if (result) {
            System.out.println("Result: '" + originalString + "' IS a palindrome.");
        } else {
            System.out.println("Result: '" + originalString + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindromeUsingStack(String str) {
        // Optional: Clean the string by removing spaces and converting to lowercase
        // for a more robust palindrome check (e.g., "Race car" -> "racecar")
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Step 1: Push characters into stack
        for (int i = 0; i < cleanStr.length(); i++) {
            stack.push(cleanStr.charAt(i));
        }

        for (int i = 0; i < cleanStr.length(); i++) {
            char poppedChar = stack.pop();

            if (poppedChar != cleanStr.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}