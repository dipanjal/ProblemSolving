# Leetcode: 206 | Reverse Linked List
# Difficulty: Easy
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-a-linked-list/

from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None, head
        while curr:
            currNext = curr.next
            curr.next = prev
            prev = curr
            curr = currNext
        return prev