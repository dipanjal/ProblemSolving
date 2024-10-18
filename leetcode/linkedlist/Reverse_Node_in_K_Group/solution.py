from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None) -> None:
        self.val = val
        self.next = next

class Solution:
    def getKthNode(self, curr: ListNode, k: int) -> Optional[ListNode]:
        while curr and k > 0:
            curr = curr.next
            k -= 1
        return curr
    
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(-1, next=head)
        prevTail = dummy
        while True:
            kthNode = self.getKthNode(prevTail)
            if not kthNode:
                # that means we have reached at the end of the linked list
                # or the last K group is not eligible for reversal
                break
            # head of the current k group
            curr = prevTail.next
            nextHead = kthNode.next
            # this is the trickiest part
            # since the current head is going to the tail of the current K group
            # current head needs to be linked with next kGroup's head
            prev = nextHead
            
            # keep reversing until curr doesn't reach of the next K groups's head
            while curr != nextHead:
                currNext = curr.next
                curr.next = prev
                prev = curr
                curr = currNext
            
            # after reversing the current K group we see the prevTail is still connected to the old head
            # we need to reconcile that and also move prevTail to the tail (old head) of current K group
            # for the upcoming k group
            prevTailNext = prevTail.next
            # reconcile prevTail with current head pointer (reversed head)
            prevTail.next = kthNode
            # move prevTail to the tail of current K group for upcoming k group
            prevTail = prevTailNext
        
        # once we break out of the while loop, means all the K groups have been reversed
        return dummy.next