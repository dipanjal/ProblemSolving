# Leetcode: 138 | Reorder Linked List
# Difficulty: Medium
# Description: https://leetcode.com/problems/reorder-list/description/
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reorder-linked-list/


from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def getNodeBeforeMiddle(self, head: Optional[ListNode]) -> ListNode:
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    def reverList(self, head: Optional[ListNode]) -> ListNode:
        left = None
        right = head
        while right:
            rightNext = right.next
            right.next = left
            left = right
            right = rightNext
        return left
        
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head:
            return
        
        # find the node before middle. 
        # because we are gonna split the linked list into 2 halves
        beforeMid = self.getNodeBeforeMiddle(head)
        # the middle node
        sec_head = beforeMid.next
        # break the link to split the linked list into two halves
        beforeMid.next = None
        
        # now, reverse the second half of the list and get the reversed head
        sec_head_rev = self.reverList(sec_head)

        # now take two pointers at the begining of the two lists
        p1 = head
        p2 = sec_head_rev
        while p2:
            p1Next = p1.next
            p2Next = p2.next
            
            p1.next = p2
            p2.next = p1Next

            p1 = p1Next
            p2 = p2Next

