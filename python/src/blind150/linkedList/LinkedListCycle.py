from src.utils.logging_util import get_logger

logger = get_logger(__name__)

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class LinkedListCycle:
    def hasCycle(self, _head: ListNode) -> bool:
        fast = _head
        slow = _head

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

            if fast == slow:
                return True
        return False

    def print_list(self, _head: ListNode):
        logger.info("Printing the list:")
        current = _head
        visited = set()
        while current:
            if current in visited:  # To handle cycles during print
                logger.info(f"Cycle detected at node with value: {current.val}")
                break
            logger.info(f"Node value: {current.val}")
            visited.add(current)
            current = current.next
        logger.info("End of list.")

if __name__ == "__main__":
    # Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    # Creating a cycle: 5 -> 3
    head.next.next.next.next.next = head.next.next

    logger.info("Original Linked List:")
    LinkedListCycle().print_list(head)

    logger.info("Checking for a cycle in the linked list...")
    has_cycle = LinkedListCycle().hasCycle(head)

    if has_cycle:
        logger.info("The linked list has a cycle.")
    else:
        logger.info("The linked list does not have a cycle.")
