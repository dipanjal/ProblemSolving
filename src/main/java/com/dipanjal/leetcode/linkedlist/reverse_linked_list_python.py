# https://leetcode.com/problems/reverse-linked-list/description/
class Solution(object):

    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        left_node = None
        curr = head
        while curr:
            # extracting the right now before changing anything
            # because we will use this `right_node` to move the `curr` node forward
            right_node = curr.next
            
            # reverse the link
            curr.next = left_node
            
            # move the pointers forward
            left_node = curr
            curr = right_node
          
        return left_node

        
