
public class PalindromeApp {
    public static void main(String[] args) {

        String originalStr = "madam";
        String reversedStr = "";

        System.out.println("Checking string: " + originalStr);

        for (int i = originalStr.length() - 1; i >= 0; i--) {
            reversedStr = reversedStr + originalStr.charAt(i);
        }

        if (originalStr.equals(reversedStr)) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }
    }

}