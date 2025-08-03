# Leetcode: 707 | Design Doubly Linked List
# Difficulty: Medium
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/design-a-doubly-linked-list/

from typing import Optional


class Node:
    def __init__(self, val: int, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next

class MyLinkedList:
    def __init__(self):
        self.size = 0
        # Dummy Head and Tail initialization
        self.head = Node(-1)
        self.tail = Node(-1)
        # Linking Dummy Head and Tail
        self.head.next = self.tail
        self.tail.prev = self.head
    
    def printList(self):
        curr = self.head
        while curr:
            print(curr.val, end=" -> ")
            curr = curr.next
        print("None")

    # Helper Function
    def getNthNode(self, curr: Node, index: int) -> Optional[Node]:
        while curr and index > 0:
            curr = curr.next
            index -= 1
        return curr

    def get(self, index: int) -> int:
        firstNode = self.head.next
        nthNode = self.getNthNode(firstNode, index)
        return nthNode.val if nthNode else -1

    # Helper Function
    def insertNode(self, value: int, prevNode: Node, nextNode: Node):
        newNode = Node(val=value, prev=prevNode, next=nextNode)
        prevNode.next = newNode
        nextNode.prev = newNode
        # increment node count by 1
        self.size += 1

    def addAtHead(self, value: int):
        # add node after the head node
        self.insertNode(value, prevNode=self.head, nextNode=self.head.next)

    def addAtTail(self, value: int):
        # add node before tail node
        self.insertNode(value, prevNode=self.tail.prev, nextNode=self.tail)

    def addAtIndex(self, index: int, value: int):
        if index > self.size:
            return
        if index == 0:
            self.addAtHead(value)
        elif index == self.size:
            self.addAtTail(value)
        else:
            beforeNthNode = self.getNthNode(self.head, index)
            self.insertNode(
                value, 
                prevNode=beforeNthNode, 
                nextNode=beforeNthNode.next
            )

    # helper function
    def deleteNode(self, nthNode: Node):
        prevNode = nthNode.prev
        nextNode = nthNode.next
        # unlink the nth node from linked list
        prevNode.next = nextNode
        nextNode.prev = prevNode
        # decrement node count by 1
        self.size -= 1

    def deleteAtIndex(self, index: int):
        if index > self.size - 1:
            return
        nthNode = self.getNthNode(self.head.next, index)
        self.deleteNode(nthNode)   


def main():
    obj = MyLinkedList()
    obj.addAtHead(2)
    obj.printList()
    obj.deleteAtIndex(1)
    obj.printList()
    obj.addAtHead(2)
    obj.printList()
    obj.addAtHead(7)
    obj.printList()
    obj.addAtHead(3)
    obj.printList()
    obj.addAtHead(2)
    obj.printList()
    obj.addAtHead(5)
    obj.printList()
    obj.addAtTail(5)
    obj.printList()
    index = 5
    print(f"GET INDEX: {index} | Val: {obj.get(index)}")
    obj.deleteAtIndex(6)
    obj.deleteAtIndex(4)


if __name__ == "__main__":
    main()