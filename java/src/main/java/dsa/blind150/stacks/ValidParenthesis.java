package dsa.blind150.stacks;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    private static final Logger logger = LoggerUtil.getLogger();

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if(stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validator = new ValidParenthesis();

        String[] testInputs = {
                "({[]})",
                "([)]",
                "",
                "({[",
                "[]",
                "{[()]}"
        };

        for (int i = 0; i < testInputs.length; i++) {
            String testInput = testInputs[i];
            logger.info("Test Case {}: Starting validation for input: {}", i + 1, testInput);
            boolean result = validator.isValid(testInput);
            logger.info("Test Case {} Result: Input {} is {}", i + 1, testInput, result ? "Valid" : "Invalid");
        }
    }

}
