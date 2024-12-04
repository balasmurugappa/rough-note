package dsa.blind150.trees;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

public class InvertTree {
    private static final Logger logger = LoggerUtil.getLogger();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode node = new TreeNode(root.val);

        node.right = invertTree(root.left);
        node.left = invertTree(root.right);

        return node;
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        // Pre-order traversal (Root, Left, Right)
        logger.info("Node value: {}", root.val);  // Log the current node's value
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        logger.info("Original Tree (In-order):");
        new InvertTree().printTree(root);

        logger.info("Inverting the tree...");
        TreeNode invertedRoot = new InvertTree().invertTree(root);

        logger.info("Inverted Tree (In-order):");
        new InvertTree().printTree(invertedRoot);
    }
}
