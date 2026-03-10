import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeApp {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Case-Insensitive & Space-Ignored Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        if (isPalindrome(processedInput)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}