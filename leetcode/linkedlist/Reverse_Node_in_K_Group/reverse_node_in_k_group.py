# Leetcode 25 | Reverse Nodes in K Group
# Difficulty: Hard
# Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-nodes-in-k-group/


from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def getKthNode(self, ptr: Optional[ListNode], k: int) -> Optional[ListNode]:
        while ptr and k > 0:
            ptr = ptr.next
            k -= 1
        return ptr

    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(next=head)
        prev_tail = dummy
        while True:
            kth_node = self.getKthNode(prev_tail, k)
            if not kth_node:
                break
            
            # the head of the next group
            # we will keep reversing until the current pointer reaches at next group's head
            next_group_head = kth_node.next
            
            # initially it's the head of the current group
            curr = prev_tail.next
            
            # initially the head of the next group
            # initially the current group head will be connected to the next group head
            # because after reversing, current group's head will be current group's tail
            prev = next_group_head

            # Reverse current Group
            while curr != next_group_head:
                curr_next = curr.next
                curr.next = prev
                prev = curr
                curr = curr_next
            
            # since .next pointer is going to be modified, so we have to save actual next pointer
            # basically `next_prev_tail` will be the new tail (i.e. old head) of current group
            next_prev_tail = prev_tail.next

            # current k group is reversed, 
            # except the prev_tail is still connected to the old head of the group
            # remember `kth_node` is always going to be new head of the group after reversal
            # since .next pointer is going to be modified, so we saved next_prev_tail earlier
            prev_tail.next = kth_node

            # now need to move the prev_tail to it's next
            prev_tail = next_prev_tail

        # all the K groups have reversed
        return dummy.next


def printList(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")

def main():
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    
    print("Original list:")
    printList(head)
    
    k = 2
    head = Solution().reverseKGroup(head, k)
    
    print("Reversed list in k-groups:")
    printList(head)

if __name__ == "__main__":
    main()