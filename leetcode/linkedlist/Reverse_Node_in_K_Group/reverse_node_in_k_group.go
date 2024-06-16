// Leetcode 25 | Reverse Nodes in K Group
// Difficulty: Hard
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-nodes-in-k-group/

package main

import "fmt"

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// Function to get the k-th node from the current pointer
func getKthNode(ptr *ListNode, k int) *ListNode {
	for ptr != nil && k > 0 {
		ptr = ptr.Next
		k--
	}
	return ptr
}

// Function to reverse nodes in k-group
func reverseKGroup(head *ListNode, k int) *ListNode {
	dummy := &ListNode{Next: head}
	prevTail := dummy
	for {
		kthNode := getKthNode(prevTail, k)

		if kthNode == nil {
			// we reached the end of the list or there are fewer than k nodes left
			break
		}

		nextGroupHead := kthNode.Next
		// initially the head of the current group
		curr := prevTail.Next
		// initially the head of the next group
		prev := nextGroupHead
		// need to connect both of the heads first
		// but we can do it while reversing

		// Reverse current group
		for curr != nextGroupHead {
			currNext := curr.Next
			curr.Next = prev
			prev = curr
			curr = currNext
		}

		// current group is reversed but the prevTail is still connect with the old head
		// let's fix it
		// since we are going to monipulate prevTail.Next pointer, let's save it in a temp variable first
		nextPrevTail := prevTail.Next
		// connting prevTail with new Head which is kthNode after reverse
		prevTail.Next = kthNode
		// get ready for next K group
		// moving prevTail to the new tail of current group
		prevTail = nextPrevTail
	}
	return dummy.Next
}

// Helper function to print the linked list
func printList(head *ListNode) {
	for head != nil {
		fmt.Printf("%d -> ", head.Val)
		head = head.Next
	}
	fmt.Println("nil")
}

func main() {
	// Create nodes
	head := &ListNode{Val: 1}
	head.Next = &ListNode{Val: 2}
	head.Next.Next = &ListNode{Val: 3}
	head.Next.Next.Next = &ListNode{Val: 4}
	head.Next.Next.Next.Next = &ListNode{Val: 5}

	// Before reversal
	fmt.Println("Original list:")
	printList(head)

	// Reverse in k-groups
	k := 2
	head = reverseKGroup(head, k)

	// After reversal
	fmt.Println("Reversed list in k-groups:")
	printList(head)
}
