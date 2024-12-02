package dsa.blind150.arrays;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

public class ValidAnagram {
    private static final Logger logger = LoggerUtil.getLogger();
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            logger.warn("{} & {} are not Anagram", a, b);
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }

        for(int val: count) {
            if (val != 0) {
                logger.warn("{} & {} are not Anagram", a, b);
                return false;
            }
        }
        logger.info("{} & {} are Anagram", a, b);
        return true;
    }

    public static void main(String[] args) {
        String src = "racecar";
        String target = "carrace";

        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram(src, target);
        validAnagram.isAnagram("cat", "eat");
    }

}
