# Leeocode 141 | Linked List Cycle
# Problem: https://leetcode.com/problems/linked-list-cycle/description/
# Difficulty: Medium
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/linked-list-cycle/

from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False


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
    has_cycle = Solution().hasCycle(head)

    if has_cycle:
        print("Cycle detected")
    else:
        print("No cycle detected")

if __name__ == "__main__":
    main()
