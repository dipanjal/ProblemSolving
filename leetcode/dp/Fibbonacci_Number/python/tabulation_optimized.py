# Leetcode 509 | Reverse Nodes in K Group
# Difficulty: Easy
# Problem: https://leetcode.com/problems/fibonacci-number/description/
# Editorial: TBA

from typing import List, Dict
import timeit

# In the previous `tabulation` solution we used an array to keep track of all previous results
# But do we really need it? The answere is No
# To compute next fibbonacchi number we just need previous 2 values
# we can use prev, curr variable to keep track of two preciding values
# And we can also drop the additional Space Complexity by removing the Array

class Solutuion:
    def fib(self, n: int) -> int:
        # our base cases are
        # F(0) = 0, F(1) = 1
        # we won't do any compulation for them
        if n == 0:
            return 0
        if n == 1:
            return 1
        
        # assign the basic prev and curr values
        prev, curr = 0, 1

        # iterate from 2 to n
        for i in range(2, n+1):
            # compute result from previous 2 result
            res = curr + prev
            # now update the prev value which is curr value
            prev = curr
            # update the curr value which is the currently computed result
            curr = res
        
        return curr


def runTests(test_suites: List[Dict[int, int]]):
    s = Solutuion()
    for suite in test_suites:
        actual: int = s.fib(suite["input"])
        assert actual == suite["expected"], f"expected: {suite['expected']}, got: {actual}"

def main():
    test_suites = [
        {"input": 0, "expected": 0},
        {"input": 1, "expected": 1},
        {"input": 2, "expected": 1},
        {"input": 3, "expected": 2},
        {"input": 4, "expected": 3},
        {"input": 5, "expected": 5},
        {"input": 6, "expected": 8},
        {"input": 7, "expected": 13},
        {"input": 30, "expected": 832040},
    ]
    start = timeit.default_timer()
    runTests(test_suites)
    elapsed_time_ms = (timeit.default_timer() - start) * 1000
    print("All assertions passed in %0.3fms"% elapsed_time_ms)

if __name__ == "__main__":
    main()
