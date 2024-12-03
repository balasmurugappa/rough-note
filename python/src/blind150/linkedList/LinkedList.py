from src.utils.logging_util import get_logger

logger = get_logger(__name__)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class LinkedList:
    def reverseLinkedList(self, _head: ListNode) -> ListNode:
        logger.info("Starting to reverse the linked list.")
        curr = _head
        prev = None

        while curr:
            logger.info(f"Reversing node with value: {curr.val}")
            _next = curr.next
            curr.next = prev
            prev = curr
            curr = _next

        logger.info("Linked list reversal complete.")
        return prev

    def printList(self, _head: ListNode):
        logger.info("Printing the list:")
        current = _head
        while current:
            logger.info(f"Node value: {current.val}")
            current = current.next
        logger.info("End of list.")

if __name__ == "__main__":
    # Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    logger.info("Original Linked List:")
    LinkedList().printList(head)

    logger.info("Reversing the linked list...")
    reversed_head = LinkedList().reverseLinkedList(head)

    logger.info("Reversed Linked List:")
    LinkedList().printList(reversed_head)



