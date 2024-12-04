package dsa.blind150.linkedlist;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

import java.util.LinkedList;


public class ReverseList {
    private static final Logger logger = LoggerUtil.getLogger();
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        logger.info("Starting the reversal process.");
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            logger.info("Reversing node with value: {}", curr.val);
            logger.info("Current head of the list: {}", curr.val);

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            if (curr != null) {
                logger.info("New head of the list: {}", curr.val);
            }
        }
        logger.info("Reversal complete. New head of the list: {}", prev.val);
        return prev;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        logger.info("Original List:");
        printList(head);

        logger.info("Reversing the list...");
        ListNode reversedHead = reverseList(head);

        logger.info("Reversed List:");
        printList(reversedHead);
    }

    public static void printList(ListNode head) {
        logger.info("Printing list:");
        ListNode current = head;
        while (current != null) {
            logger.info("Node value: {}", current.val);
            current = current.next;
        }
        logger.info("End of list.");
    }
}

