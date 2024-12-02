package dsa.blind150.arrays;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

import java.util.HashMap;

public class TwoSum {
    private static final Logger logger = LoggerUtil.getLogger();
    public static int[] find(int[] array, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int targetNum = target - num;

            if (hashMap.containsKey(targetNum)) {
                logger.info("Found pair: {} + {} = {}", num, targetNum, target);
                return new int[]{hashMap.get(targetNum), i};
            }

            hashMap.put(num, i);
        }

        logger.warn("No pair found that adds up to {}", target);
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {0, 6, 2, 7, 11, 15};
        int target = 9;

        int[] result = find(nums, target);

        if (result[0] != -1 && result[1] != -1) {
            logger.info("Indices found at: {}, {}", result[0], result[1]);
        } else {
            logger.warn("No valid pair found.");
        }
    }
}