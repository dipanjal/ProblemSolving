/**
 * Leetcode 206 | Reverse Linked List (recursive approach)
 * Difficulty: Easy
 * Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-a-linked-list-recursive/
 */

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	revHead := head
	if head.Next != nil {
		revHead = reverseList(head.Next)
		rightNode := head.Next
		rightNode.Next = head
	}
	head.Next = nil
	return revHead
}
