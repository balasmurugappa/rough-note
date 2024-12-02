from curses.ascii import isalpha, isdigit

from src.utils.logging_util import get_logger

logger = get_logger(__name__)

class ValidPalindrome:
    def isPalindrome(self, s: str) -> bool:
        start, end = 0, len(s) - 1

        while start < end:
            while start < end and not s[start].isalpha() and not s[start].isdigit():
                logger.debug(f"Skipping non-alphanumeric character at start: {s[start]}")
                start += 1

            while start < end and not s[end].isalpha() and not s[end].isdigit():
                logger.debug(f"Skipping non-alphanumeric character at end: {s[end]}")
                end -= 1

            if s[start].lower() != s[end].lower():
                logger.warn(f"Mismatch found: {s[start]} != {s[end]} at positions {start} and {end}")
                return False

            start += 1
            end -= 1

        logger.info("The string is a palindrome.")
        return True


# Driver code
if __name__ == "__main__":
    valid_palindrome = ValidPalindrome()

    test_cases = [
        "A man, a plan, a canal: Panama",
        "race a car",
        " ",
        "No 'x' in Nixon",
        "hello",
        "madam"
    ]

    for test_case in test_cases:
        logger.info(f"Checking if '{test_case}' is a palindrome...")
        result = valid_palindrome.isPalindrome(test_case)
        logger.info(f"Is '{test_case}' a palindrome? {result}")