/**
 * Leetcode 142 | Linked List Cycle II
 * Problem: https://leetcode.com/problems/linked-list-cycle-ii/description/
 * Difficulty: Medium
 */

package main

import "fmt"

// ListNode defines a node in the linked list
type ListNode struct {
	Val  int
	Next *ListNode
}

// detectCycle returns the node where the cycle begins. If there is no cycle, return nil.
func detectCycle(head *ListNode) *ListNode {
	slow, fast := head, head
	var hasCycle bool

	// Detect if a cycle exists
	// first need to confirm that the linked list has a cycle
	// explanation for linked list cycle detection
	// https://dipanjals-notebook.vercel.app/leetcode/linked-list/linked-list-cycle/
	// this is the prerequisite one
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			hasCycle = true
			break
		}
	}

	// If there is no cycle, return null.
	if !hasCycle {
		return nil
	}

	// Find the starting node of the cycle
	// at this point we are sure that the linked list has a cycle.
	// let's find the begining node where the cycle has started
	curr := head

	// we know that at some point curr and slow will meet eachother,
	// according to the Floyed's algorithm
	// the loop will stop when both of the pointers meet with eachother
	// and the meeting point is the begining of the cycle
	for curr != slow {
		curr = curr.Next
		slow = slow.Next
	}

	return curr
}

func main() {
	// Example to test the detectCycle function
	head := &ListNode{Val: 3}
	node2 := &ListNode{Val: 2}
	node0 := &ListNode{Val: 0}
	node4 := &ListNode{Val: -4}

	head.Next = node2
	node2.Next = node0
	node0.Next = node4
	node4.Next = node2 // Cycle here

	cycleNode := detectCycle(head)
	if cycleNode != nil {
		fmt.Println("Cycle detected at node with value:", cycleNode.Val)
	} else {
		fmt.Println("No cycle detected")
	}
}
