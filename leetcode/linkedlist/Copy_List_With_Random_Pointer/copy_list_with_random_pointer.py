# Leetcode: 138 | Copy List with Random Pointer
# Difficulty: Medium
# Description: https://leetcode.com/problems/copy-list-with-random-pointer/description/
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/copy-list-with-random-pointer/

from typing import Optional

# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
		
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        nodeMap = {None: None}
        # At the first pass, we will create new nodes with the values of the original nodes
        # But ignore the next and random pointer. we will do it in the second pass
        curr = head
        while curr:
            nodeMap[curr] = Node(curr.val)
            curr = curr.next
        
        # Now again starting from the head, and connect the next and random pointers
        # In our hashmap, We have already created the copies of the nodes
        # that has been pointed by next and random pointer
        # it's time to connect them for the copy nodes
        curr = head
        while curr:
            currCopy = nodeMap[curr]
            currCopy.next = nodeMap[curr.next]
            currCopy.random = nodeMap[curr.random]
            curr = curr.next
        # now return the copy of the head, which we can find from the hashmap
        return nodeMap[head]