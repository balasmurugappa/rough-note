from src.utils.logging_util import get_logger

logger = get_logger(__name__)
class ValidParenthesis:
    def isValid(self, s: str) -> bool:
        logger.info("isValid method invoked with input: %s", s)
        stack = []
        _map = {"(": ")", "{": "}", "[": "]"}

        for c in s:
            logger.debug("Processing character: %s", c)
            if c in _map:
                if stack and stack[-1] != c:
                    stack.pop()
                else:
                    logger.warning("Mismatch found for opening bracket %s. Returning False.", c)
                    return False
            else:
                logger.debug("Pushing character %s to stack.", c)
                stack.append(c)

        is_valid = not stack
        logger.info("Validation complete. Result: %s", "Valid" if is_valid else "Invalid")
        return is_valid

# Driver Code
if __name__ == "__main__":
    validator = ValidParenthesis()

    test_inputs = [
        "({[]})",
        "([)]",
        "",
        "({[",
        "[]",
    ]

    for i, test_input in enumerate(test_inputs, 1):
        logger.info("Test Case %d: Starting validation for input: %s", i, test_input)
        result = validator.isValid(test_input)
        logger.info("Test Case %d Result: Input '%s' is %s", i, test_input, "Valid" if result else "Invalid")
