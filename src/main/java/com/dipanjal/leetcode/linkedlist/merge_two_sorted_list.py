# https://leetcode.com/problems/merge-two-sorted-lists

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    
    def mergeTwoLists(self, list1, list2):
        dummy_head = ListNode(-1)
        tail = dummy_head
        
        while list1 and list2:
            if list1.val < list2.val:
                # add to tail
                tail.next = list1
                # move forward 
                list1 = list1.next
            else:
                # add to tail
                tail.next = list2
                # move forward 
                list2 = list2.next
            
            tail = tail.next
        
        # collect the remaining and append with the tail of the output
        if list1:
            tail.next = list1
        if list2:
            tail.next = list2

        return dummy_head.next
