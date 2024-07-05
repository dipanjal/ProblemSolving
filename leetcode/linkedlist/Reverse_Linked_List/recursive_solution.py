from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        printList(head)
        
        # Just a safety check
        if not head:
            print("returning null")
            return None

        revHead = head
        print(f"revHead={revHead.val}")
        if head.next:
            print(f"---------------going deep: reverseList({head.next.val})---------------")
            revHead = self.reverseList(head.next)

            print(f"reversing with Head {head.val}")
            # Reversing the link
            rightNode = head.next  # right node of the current head
            rightNode.next = head

        # After all the recursion calls let's connect the current head with None
        head.next = None
        print(f"Reversed List after connecting {head.val} with None: {head.val}->None")
        print(f"rettrning revHead={revHead.val}")
        printList(revHead)
        print("--------------------")
        # return to the previous recursion call
        return revHead


# Function to print the linked list
def printList(head: Optional[ListNode]):
    curr = head
    while curr:
        print(curr.val, end=" -> ")
        curr = curr.next
    print("None")

# Function to create a linked list from a list of values
def createLinkedList(values):
    if not values:
        return None
    head = ListNode(values[0])
    curr = head
    for val in values[1:]:
        curr.next = ListNode(val)
        curr = curr.next
    return head

def main():
    # Create a linked list from a list of values
    values = [1, 2, 3, 4, 5]
    
    # Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> None
    print("Original list:")
    head = createLinkedList(values)

    # Reversing the linked list
    sol = Solution()
    reversed_head = sol.reverseList(head)

    print("Reversed list:")
    printList(reversed_head)

if __name__ == "__main__":
    main()
