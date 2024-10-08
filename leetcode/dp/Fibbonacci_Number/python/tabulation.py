# Leetcode 509 | Reverse Nodes in K Group
# Difficulty: Easy
# Problem: https://leetcode.com/problems/fibonacci-number/description/
# Editorial: TBA

from typing import List, Dict
import timeit

# 3rd Approach: Replace Recursion with Iteration
# Previously, in recursion, we have seen that our solution is started from the Top 
# ex: F(N), where N = 6
# And we keep going into the deep until we meet our base cases
# That's why Recursion is called Top-Down approach

# But in iterative approach we will start from the ground EX: F(2) and climbup until F(N)
# I have mentioned F(2), because F(0) and F(1) is our base inputs.
# we will hardcode result for F(0) and F(1), no compulations will be needed for them.
# Time Complexity: O(N)
# Space Complexity: O(N) | Because we are using array to keep track of the previous results

class Solutuion:
    def fib(self, n: int) -> int:
        # our base cases are
        # F(0) = 0, F(1) = 1
        # we won't do any compulation for them
        if n == 0:
            return 0
        if n == 1:
            return 1
        
        # let's take a DP Array size N + 1 because N will be our last index
        size = n + 1
        results = [0] * size
        # assign the base values in results
        results[1] = 1

        # iterate from 2 to n
        for i in range(2, size):
            # compute result from previous 2 result
            # save the computed result in the current index
            results[i] = results[i-1] + results[i-2]
        
        return results[n]
        


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
