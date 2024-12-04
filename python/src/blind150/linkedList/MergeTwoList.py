from src.utils.logging_util import get_logger

logger = get_logger(__name__)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class MergeTwoList:
    def merge_two_list(self, list1: ListNode, list2: ListNode) -> ListNode:
        temp = node = ListNode()

        while list1 and list2:
            if list1.val < list2.val:
                node.next = list1
                list1 = list1.next
            else:
                node.next = list2
                list2 = list2.next

            node = node.next

        # Linking remaining nodes from either list1 or list2
        if list1:
            node.next = list1
        elif list2:
            node.next = list2

        return temp.next

    def print_list(self, _head: ListNode):
        logger.info("Printing the list:")
        current = _head
        while current:
            logger.info(f"Node value: {current.val}")
            current = current.next
        logger.info("End of list.")

if __name__ == "__main__":
    # Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
    list1 = ListNode(1)
    list1.next = ListNode(3)
    list1.next.next = ListNode(5)

    list2 = ListNode(2)
    list2.next = ListNode(4)
    list2.next.next = ListNode(6)

    logger.info("Original Linked List 1:")
    MergeTwoList().print_list(list1)

    logger.info("Original Linked List 2:")
    MergeTwoList().print_list(list2)

    logger.info("Merging the linked list...")
    mergedList = MergeTwoList().merge_two_list(list1, list2)

    logger.info("Merged Linked List:")
    MergeTwoList().print_list(mergedList)