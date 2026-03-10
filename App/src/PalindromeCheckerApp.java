
import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String originalStr = scanner.nextLine();
        String reversedStr = "";

        // 1. Reverse string using a for loop and string concatenation
        for (int i = originalStr.length() - 1; i >= 0; i--) {
            reversedStr = reversedStr + originalStr.charAt(i);
        }

        // 2. Compare original and reversed using equals()
        if (originalStr.equals(reversedStr)) {
            System.out.println("Result: '" + originalStr + "' is a Palindrome.");
        } else {
            System.out.println("Result: '" + originalStr + "' is NOT a Palindrome.");
        }

        scanner.close();
    }
}
