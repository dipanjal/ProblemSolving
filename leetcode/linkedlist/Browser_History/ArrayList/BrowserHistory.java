// Leetcode: 1472 | Design Browser Histroy (Optimized)
// Difficulty: Medium
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/design-browser-history-optimized/

// Optimized Solution using ArrayList
// Visit -> O(1) | Same as Linked List
// Forward -> O(1) Direct Index access | Taking O(n) for Linked List
// Back -> O(1) Direct Index access | Taking O(n) for Linked List

class BrowserHistory {

    List<String> list = new ArrayList<>();

    int end = 0;
    int curr = 0;
    public BrowserHistory(String homepage) {
        list.add(homepage);
        end = 0;
        curr = 0;
    }
    
    public void visit(String url) {
        // at this point we know for sure that
        // there is a homepage already exists in 0 index of the array
        // just increment curr index for the next url
        curr++; 
        if(list.size() > curr) {
            // means there are already forward history in the arraylist
            // user maybe moved backword and now vising to a new page
            // we are just replacing the url from the specific index
            list.set(curr, url);
        } else {
            // adding new url which will increment the arrayList size
            list.add(url);
        }
        end = curr;
    }
    
    public String back(int steps) {
        // as our fist valid index is 0
        // we can not go back more than that.
        // hadling array index out of lower bound
        curr = Math.max(0, curr-steps);
        // pick the item from array in O(1) time
        return list.get(curr);
    }
    
    public String forward(int steps) {
        // as we don't really delete unused history
        // end is out valid upper bound not (list.size() - 1)
        // doing upper bound validation
        curr = Math.min(end, curr+steps);
        // pick the item from array in O(1) time
        return list.get(curr);
    }
}