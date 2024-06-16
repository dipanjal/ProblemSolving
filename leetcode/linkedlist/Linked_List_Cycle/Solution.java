public class Solution {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Main Function is not necessary unless you want to run this code in your local env
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
        boolean hasCycle = solution.hasCycle(head);

        if (hasCycle) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}