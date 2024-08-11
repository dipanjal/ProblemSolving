from typing import Optional, List

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoSortedLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        curr = dummy
        while list1 and list2:
            if list1.val < list2.val:
                curr = ListNode(list1.val)
                list1 = list1.next
            else:
                curr = ListNode(list2.val)
                list2 = list2.next
            curr = curr.next
        return dummy.next
        
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        while len(lists) > 1:
            merged_lists = []
            for i in range(0, len(lists), 2):
                list1 = lists[i]
                list2 = lists[i + 1] if (i + 1) < len(list) else None
                merged_lists.append(self.mergeTwoSortedLists(list1, list2))
            lists = merged_lists
        return lists[0]