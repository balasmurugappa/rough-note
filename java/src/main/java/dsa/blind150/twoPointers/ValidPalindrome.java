package dsa.blind150.twoPointers;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

public class ValidPalindrome {
    private static final Logger logger = LoggerUtil.getLogger();

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                logger.debug("Skipping non-alphanumeric character at start: {}", s.charAt(start));
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                logger.debug("Skipping non-alphanumeric character at end: {}", s.charAt(end));
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                logger.warn("Mismatch found: {} != {} at positions {} and {}",
                        s.charAt(start), s.charAt(end), start, end);
                return false;
            }
            start++;
            end--;
        }
        logger.info("The string '{}' is a palindrome", s);
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        String[] testCases = {
                "A man, a plan, a canal: Panama", // Expected: true
                "race a car",                    // Expected: false
                " ",                             // Expected: true
                "No 'x' in Nixon"                // Expected: true
        };

        for (String testCase : testCases) {
            logger.info("Checking if '{}' is a palindrome", testCase);
            boolean result = validPalindrome.isPalindrome(testCase);
            logger.info("Result: {}", result ? "Palindrome" : "Not Palindrome");
        }
    }
}