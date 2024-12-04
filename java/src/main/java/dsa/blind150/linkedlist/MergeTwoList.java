package dsa.blind150.linkedlist;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

public class MergeTwoList {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        logger.info("Starting merge process...");
        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        while (l1 != null && l2 != null) {
            logger.info("Comparing values: l1 = {}, l2 = {}", l1.val, l2.val);
            if (l1.val < l2.val) {
                logger.info("Choosing l1 node with value: {}", l1.val);
                curr.next = l1;
                l1 = l1.next;
            } else {
                logger.info("Choosing l2 node with value: {}", l2.val);
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // If one of the lists is not empty, link the remainder
        if (l1 != null) {
            logger.info("Remaining nodes from l1 are appended.");
        } else if (l2 != null) {
            logger.info("Remaining nodes from l2 are appended.");
        }

        curr.next = l1 == null ? l2 : l1;
        logger.info("Merge completed.");
        return temp.next;
    }

    public static void main(String[] args) {
        // Create first linked list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Create second linked list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        logger.info("Original List 1:");
        printList(list1);

        logger.info("Original List 2:");
        printList(list2);

        logger.info("Merging the two lists...");
        ListNode mergedList = mergeTwoLists(list1, list2);

        logger.info("Merged List:");
        printList(mergedList);
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
