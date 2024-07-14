# Leetcode: 1472 | Design Browser Histroy (Optimized)
# Difficulty: Medium
# Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/design-browser-history-optimized/

# Optimized Solution using ArrayList
# Visit -> O(1) | Same as Linked List
# Forward -> O(1) Direct Index access | Taking O(n) for Linked List
# Back -> O(1) Direct Index access | Taking O(n) for Linked List

class BrowserHistory:

    def __init__(self, homepage: str):
        # instead of linked-list we are using plain array list
        self.history = []
        self.history.append(homepage)
        
        # curr means the current index
        self.curr = 0
        
        # end means the last valid index to validate upper bound
        # end is needed because we are not deleting history from the array list
        # so len(history) - 1 will not work for us
        # we need to maintain the end pointer with the curr pointer as well
        # you will see that in foward() and visit() function
        self.end = self.curr

    
    def visit(self, url: str) -> None:
        # append at the next position
        # we are using curr poiner to append in the list
        # at this point we already know that our curr is already at 0 
        # because the homepage is at the 0th index
        # now, increment curr for next index, 
        # ex: curr=0, curr = curr + 1 is the next valid index
        self.curr += 1

        # if the next position is less than the array length, 
        # that means the array already has past history
        if self.curr < len(self.history):
            # so we need to update that specific index with the given url
            self.history[self.curr] = url
        else:
            # we know the array has no past histrory, we need to append at the next position
            self.history.append(url)

        # point end at the latest index. because end is our valid last index
        self.end = self.curr

    def back(self, steps: int) -> str:
        # We are calculating which index to go back from the current position using steps
        lowerIndex = self.curr - steps
        
        # but think about Array Index Out of Lower Bound
        # for example: curr = 3, steps = 5,
        # hence index= 3 - 5 = -2 which we can not accept.
        # whatever steps they want you to go back, 
        # your lowest index is 0, you can not got bellow zero
        self.curr = max(0, lowerIndex)
        return self.history[self.curr]

    def forward(self, steps: int) -> str:
        # calculating which index to move forward from the current position using steps
        upperIndex = self.curr + steps

        # but think about Array Index Out of Upper Bound
        # for example: end = 3, curr = 1, steps = 4
        # hence upperIndex = 1 + 4 = 5 which we can not accept.
        # whatever steps they want us to move forwrad,
        # we can not go beyond our end index
        self.curr = min(self.end, upperIndex)
        return self.history[self.curr]
        

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)