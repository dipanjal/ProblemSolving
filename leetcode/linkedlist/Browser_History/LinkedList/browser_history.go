// Leetcode: 1472 | Design Browser Histroy (Linked List Solution)
// Difficulty: Medium
// Editorial: TBA

package main

type Node struct {
	Val  string
	Prev *Node
	Next *Node
}

type BrowserHistory struct {
	Curr *Node
}

func Constructor(homepage string) BrowserHistory {
	node := &Node{Val: homepage}
	return BrowserHistory{Curr: node}
}

// O(1) operational time complexity
func (this *BrowserHistory) Visit(url string) {
	this.Curr.Next = &Node{Val: url, Prev: this.Curr}
	this.Curr = this.Curr.Next
}

// O(n) operational time complexity
func (this *BrowserHistory) Back(steps int) string {
	for this.Curr.Prev != nil && steps > 0 {
		this.Curr = this.Curr.Prev
		steps--
	}
	return this.Curr.Val
}

// O(n) operational time complexity
func (this *BrowserHistory) Forward(steps int) string {
	for this.Curr.Next != nil && steps > 0 {
		this.Curr = this.Curr.Next
		steps--
	}
	return this.Curr.Val
}
