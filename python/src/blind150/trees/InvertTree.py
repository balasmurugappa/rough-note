from src.utils.logging_util import get_logger

logger = get_logger(__name__)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class InvertTree:

    def invert_tree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None

        # Swap the left and right children
        root.left, root.right = root.right, root.left

        # Recursively invert the left and right subtrees
        self.invert_tree(root.left)
        self.invert_tree(root.right)

        return root

    def print_tree(self, root: TreeNode) -> None:
        if root is None:
            return
        # Pre-order traversal to print the tree
        print(f"Node value: {root.val}")
        self.print_tree(root.left)
        self.print_tree(root.right)

# Driver code
if __name__ == "__main__":
    # Create a sample binary tree:
    #         1
    #       /   \
    #      2     3
    #     / \   / \
    #    4   5 6   7
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)

    print("Original Tree:")
    InvertTree().print_tree(root)

    print("\nInverting the tree...")
    inverted_root = InvertTree().invert_tree(root)

    print("\nInverted Tree:")
    InvertTree().print_tree(inverted_root)
