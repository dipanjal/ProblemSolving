class BrowserHistory {
    private static class Node {
        String val;
        Node prev, next;
        public Node(String val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node curr;
    public BrowserHistory(String homepage) {
        this.curr = new Node(homepage, null, null);
    }
    
    public void visit(String url) {
        this.curr.next = new Node(url, this.curr, null);
        this.curr = this.curr.next;
    }
    
    public String back(int steps) {
        while (this.curr.prev != null && steps > 0) {
            this.curr = this.curr.prev;
            steps--;
        }
        return this.curr.val;
    }
    
    public String forward(int steps) {
        while (this.curr.next != null && steps > 0) {
            this.curr = this.curr.next;
            steps--;
        }
        return this.curr.val;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        assert browserHistory.back(1).equals("facebook.com");  // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        assert browserHistory.back(1).equals("google.com");    // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        assert browserHistory.forward(2).equals("linkedin.com");  // You are in "linkedin.com", you cannot move forward any steps.
        assert browserHistory.back(2).equals("google.com");    // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        assert browserHistory.back(7).equals("leetcode.com");  // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
        
        System.out.println("All assertions passed!");
    }
    // Run the code with assertion enabled: java -ea BrowserHistory
}

