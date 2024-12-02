from typing import List
from src.utils.logging_util import get_logger

logger = get_logger(__name__)

class ValidAnagram:
    def isValidAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            logger.warning("The strings '%s' and '%s' are not anagrams (different lengths)", s, t)
            return False

        count = [0] * 26

        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1
            count[ord(t[i]) - ord('a')] -= 1

        for val in count:
            if val != 0:
                logger.warning("The strings '%s' and '%s' are not anagrams (character frequencies don't match)", s, t)
                return False

        logger.info("The strings '%s' and '%s' are anagrams", s, t)
        return True

if __name__ == "__main__":
    valid_anagram = ValidAnagram()

    valid_anagram.isValidAnagram("racecar", "carrace")
    valid_anagram.isValidAnagram("cat", "eat")
    valid_anagram.isValidAnagram("hello", "world")