/**
 * Leetcode 206 | Reverse Linked List
 * Difficulty: Easy
 * Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-a-linked-list/
 */

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode = nil
	curr := head
	for curr != nil {
		currNext := curr.Next
		curr.Next = prev
		prev = curr
		curr = currNext
	}
	return prev
}
