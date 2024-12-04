package dsa.blind150.linkedlist;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

public class LinkedListCycle {
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

    public static boolean detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);

        head.next.next.next.next.next = head.next.next;
//
//        logger.info("Original List:");
//        printList(head);

        logger.info("Cycle List:");
        boolean hasCycle = detectCycle(head);

        logger.info("Detected cycle? " + hasCycle);

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
