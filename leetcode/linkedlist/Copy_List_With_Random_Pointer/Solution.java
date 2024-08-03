// Leetcode: 138 | Copy List with Random Pointer
// Difficulty: Medium
// Description: https://leetcode.com/problems/copy-list-with-random-pointer/description/
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/copy-list-with-random-pointer/


class Solution {
    public static class Node {
        int val;
        Node next;
        Node random;
        public Node(int x, Node next, Node random) {
            this.val = x;
            this.next = next;
            this.random = random;
        }
        public void setPointers(Node next, Node random) {
            this.next = next;
            this.random = random;
        }
        
        // This function is necessary only when you want to run and debug the code locally
        public static void printList(Node head) {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(null, null);

        // First Pass: Copy the Node in HashMap
        Node curr = head;
        while (curr != null) {
            nodeMap.put(
                curr, new Node(curr.val, null, null)
            );
            curr = curr.next;
        }

        // Second Pass: link the pointers among copied nodes
        curr = head;
        while(curr != null) {
            Node nodeCopied = nodeMap.get(curr);
            nodeCopied.next = nodeMap(curr.next);
            nodeCopied.random = nodeMap(curr.random);
            curr = curr.next;
        }
        // return the head of the copied list
        return nodeMap.get(head);
    }

    public static void main(String [] args) {
        

        // construct linked list nodes
        Node head = new Node(7, null, null);
        Node two = new Node(13, null, null);
        Node three = new Node(11, null, null);
        Node four = new Node(10, null, null);
        Node five = new Node(1, null, null);

        // connect the links
        head.setPointers(two, null);
        two.setPointers(three, head);
        three.setPointers(four, five);
        four.setPointers(five, three);
        five.setPointers(null, head);
        
        Node.printList(head);



        Solution s = new Solution();
        Node headCopied = s.copyRandomList();
        Node.printList(headCopied);
    }
}