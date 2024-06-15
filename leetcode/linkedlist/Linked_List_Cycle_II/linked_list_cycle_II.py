# Leetcode 142 | Linked List Cycle II
# Problem: https://leetcode.com/problems/linked-list-cycle-ii/description/
# Difficulty: Medium


from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # first need to confirm that the linked list has a cycle
        # explanation for linked list cycle detection
        # https://dipanjals-notebook.vercel.app/leetcode/linked-list/linked-list-cycle/
        # this is the prerequisite one

        has_cycle = False
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                has_cycle = True
                break
        
        # If there is no cycle, return null.
        if not has_cycle:
            return None
        
        # at this point we are sure that the linked list has a cycle. 
        # let's find the begining node where the cycle has started
        curr = head
        # we know that at some point curr and slow will meet eachother,
        # according to the Floyed's algorithm 
        # the loop will stop when both of the pointers meet with eachother
        # and the meeting point is the begining of the cycle
        while curr != slow:
            curr = curr.next
            slow = slow.next
        
        # we have found the meeting point hence the begining node of the cycle
        return curr

def main():
    # Create nodes
    head = ListNode(3)
    node2 = ListNode(2)
    node0 = ListNode(0)
    node4 = ListNode(-4)

    # Connect nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2
    head.next = node2
    node2.next = node0
    node0.next = node4
    node4.next = node2  # Cycle here

    # Detect cycle
    cycle_node = Solution().detectCycle(head)

    if cycle_node:
        print("Cycle detected at node with value:", cycle_node.val)
    else:
        print("No cycle detected")

if __name__ == "__main__":
    main()