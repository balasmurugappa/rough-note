package dsa.blind150.arrays;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    private static final Logger logger = LoggerUtil.getLogger();
    public boolean hasDuplicate(int[] nums) {
        logger.info("Checking for duplicates in array: {}", nums);
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.contains(num)) {
                logger.warn("Duplicate found: {}", num);
                return true;
            }
            unique.add(num);
        }
        logger.info("No duplicates found.");
        return false;
    }

    public static void main(String[] args) {
        int[] hasDuplicates = {1, 2, 3, 1};
        int[] hasNoDuplicates = {1, 2, 3, 4};

        ContainsDuplicate solution = new ContainsDuplicate();

        System.out.println(solution.hasDuplicate(hasDuplicates)); // Output: true
        System.out.println(solution.hasDuplicate(hasNoDuplicates)); // Output: false
    }
}