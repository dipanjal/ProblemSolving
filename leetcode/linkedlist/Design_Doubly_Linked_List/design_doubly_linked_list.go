// Leetcode: 707 | Design Doubly Linked List
// Difficulty: Medium
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/design-a-doubly-linked-list/

package main

import "fmt"

type Node struct {
	val  int
	prev *Node
	next *Node
}

type MyLinkedList struct {
	size int
	head *Node
	tail *Node
}

func Constructor() MyLinkedList {
	// Initialiing Head and Tail Nodes
	head := &Node{-1, nil, nil}
	tail := &Node{-1, nil, nil}
	// Connecting Head and Tail
	head.next = tail
	tail.prev = head
	return MyLinkedList{0, head, tail}
}

func (this *MyLinkedList) GetNthNode(curr *Node, index int) *Node {
	for curr != nil && index > 0 {
		curr = curr.next
		index--
	}
	return curr
}

func (this *MyLinkedList) Get(index int) int {
	firstNode := this.head.next
	nthNode := this.GetNthNode(firstNode, index)
	if nthNode != nil {
		return nthNode.val
	}
	return -1
}

func (this *MyLinkedList) Insert(val int, prev *Node, next *Node) {
	newNode := &Node{val, prev, next}
	prev.next = newNode
	next.prev = newNode
	this.size++
}

func (this *MyLinkedList) AddAtHead(val int) {
	this.Insert(val, this.head, this.head.next)
}

func (this *MyLinkedList) AddAtTail(val int) {
	this.Insert(val, this.tail.prev, this.tail)
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index > this.size {
		return
	}
	if index == 0 {
		this.AddAtHead(val)
	} else if index == this.size {
		this.AddAtTail(val)
	} else {
		beforeNthNode := this.GetNthNode(this.head, index)
		this.Insert(val, beforeNthNode, beforeNthNode.next)
	}
}

func (this *MyLinkedList) Delete(node *Node) {
	prevNode := node.prev
	nextNode := node.next
	// Unlink the node
	prevNode.next = nextNode
	nextNode.prev = prevNode
	this.size--
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index > this.size-1 {
		return
	}
	firstNode := this.head.next
	nodeToDelete := this.GetNthNode(firstNode, index)
	this.Delete(nodeToDelete)
}

func (this *MyLinkedList) PrintList() {
	curr := this.head.next
	for curr != this.tail {
		fmt.Print(curr.val, " -> ")
		curr = curr.next
	}
	fmt.Println("None")
}

func main() {
	obj := Constructor()
	obj.AddAtHead(2)
	obj.PrintList()
	obj.DeleteAtIndex(1)
	obj.PrintList()
	obj.AddAtHead(2)
	obj.PrintList()
	obj.AddAtHead(7)
	obj.PrintList()
	obj.AddAtHead(3)
	obj.PrintList()
	obj.AddAtHead(2)
	obj.PrintList()
	obj.AddAtHead(5)
	obj.PrintList()
	obj.AddAtTail(5)
	obj.PrintList()
	val := obj.Get(5)
	fmt.Println(val) // Expected Output: 2
	obj.DeleteAtIndex(6)
	obj.DeleteAtIndex(4)
}
