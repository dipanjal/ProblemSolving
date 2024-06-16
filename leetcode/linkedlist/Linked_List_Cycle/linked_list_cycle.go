package main

import "fmt"

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// Function to detect if the linked list has a cycle
func hasCycle(head *ListNode) bool {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return true
		}
	}
	return false
}

func main() {
	// Create nodes
	head := &ListNode{Val: 3}
	node2 := &ListNode{Val: 2}
	node0 := &ListNode{Val: 0}
	node4 := &ListNode{Val: -4}

	// Connect nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2
	head.Next = node2
	node2.Next = node0
	node0.Next = node4
	node4.Next = node2 // Cycle here

	// Detect cycle
	if hasCycle(head) {
		fmt.Println("Cycle detected")
	} else {
		fmt.Println("No cycle detected")
	}
}
