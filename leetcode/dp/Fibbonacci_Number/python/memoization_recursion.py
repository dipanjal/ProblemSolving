# Leetcode 509 | Reverse Nodes in K Group
# Difficulty: Easy
# Problem: https://leetcode.com/problems/fibonacci-number/description/
# Editorial: TBA

from typing import List, Dict
import timeit

# Our second approach Memoization (a.k.a caching)
# We still will be using Recursion
# Recursion (Top Down) + DP (Caching)

# We noticed that we are recalculating already solved sub-problems
# We are going to memoize the overlapping subproblems
# such as: F(0) = 0, F(1) = 1
# => F(3) = F(2) + F(1) 
# => (F(1) + F(0)) + F(1)
# Here the F(1) is the overlapping subproblem.
# As it grows it will have more overlapping sub-problems we can cache to reduce the computation time

# Time Complexity: O(n)
# Space Complexity: O(n) where n is the depth of the recrusion tree

class Solutuion:
    def __init__(self) -> None:
        # our base cases are
        # F(0) = 0, F(1) = 1
        # Let's cache them first
        self.cache = {0: 0, 1: 1}

    def fib(self, n: int) -> int:
        
        
        # check if we already computed the n
        if n in self.cache:
            # then we won't re-compute, just return the result from cache
            return self.cache[n]
        else:
            # compute the result first
            res = self.fib(n-1) + self.fib(n-2)
            # cache or memoize the result
            self.cache[n] = res
            # return the result
            return res


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
