class Node:
    def __init__(self, val: str, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next

class BrowserHistory:

    def __init__(self, homepage: str):
        self.curr = Node(val=homepage)
    
    def visit(self, url: str) -> None:
        self.curr.next = Node(val=url, prev=self.curr)
        self.curr = self.curr.next


    def back(self, steps: int) -> str:
        while self.curr.prev and steps > 0:
            self.curr = self.curr.prev
            steps -= 1
        return self.curr.val

    def forward(self, steps: int) -> str:
        while self.curr.next and steps > 0:
            self.curr = self.curr.next
            steps -= 1
        return self.curr.val
        

def main():
    browserHistory = BrowserHistory("leetcode.com")
    browserHistory.visit("google.com");       # You are in "leetcode.com". Visit "google.com"
    browserHistory.visit("facebook.com");     # You are in "google.com". Visit "facebook.com"
    browserHistory.visit("youtube.com");      # You are in "facebook.com". Visit "youtube.com"
    assert browserHistory.back(1) == "facebook.com"                   # You are in "youtube.com", move back to "facebook.com" return "facebook.com"
    assert browserHistory.back(1) == "google.com"                    # You are in "facebook.com", move back to "google.com" return "google.com"
    browserHistory.forward(1) == "facebook.com"                # You are in "google.com", move forward to "facebook.com" return "facebook.com"
    browserHistory.visit("linkedin.com")     # You are in "facebook.com". Visit "linkedin.com"
    assert browserHistory.forward(2) == "linkedin.com"             # You are in "linkedin.com", you cannot move forward any steps.
    assert browserHistory.back(2) == "google.com"                   # You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
    assert browserHistory.back(7) == "leetcode.com"                   # You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    print("All assertions passed!")

if __name__ == "__main__":
    main()