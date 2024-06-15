/**
 * Leetcode 142 | Linked List Cycle II
 * Problem: https://leetcode.com/problems/linked-list-cycle-ii/description/
 * Difficulty: Medium
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // first need to confirm that the linked list has a cycle
        // explanation for linked list cycle detection
        // https://dipanjals-notebook.vercel.app/leetcode/linked-list/linked-list-cycle/
        // this is the prerequisite one
        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        // If there is no cycle, return null.
        if (!hasCycle) {
            return null;
        }

        // at this point we are sure that the linked list has a cycle. 
        // let's find the begining node where the cycle has started
        ListNode curr = head;

        // we know that at some point curr and slow will meet eachother,
        // according to the Floyed's algorithm 
        // the loop will stop when both of the pointers meet with eachother
        // and the meeting point is the begining of the cycle
        while (curr != slow) {
            curr = curr.next;
            slow = slow.next;
        }

        // we have found the meeting point hence the begining node of the cycle
        return curr;
    }

    // Ignore the main function
    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        
        // Connect nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Cycle here

        // Detect cycle
        Solution solution = new Solution();
        ListNode cycleNode = solution.detectCycle(head);

        if (cycleNode != null) {
            System.out.println("Cycle detected at node with value: " + cycleNode.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}