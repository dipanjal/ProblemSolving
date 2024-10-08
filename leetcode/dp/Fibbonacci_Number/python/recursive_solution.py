# Leetcode 509 | Reverse Nodes in K Group
# Difficulty: Easy
# Problem: https://leetcode.com/problems/fibonacci-number/description/
# Editorial: TBA

from typing import List, Dict
import timeit

# Our first approach will be plain recursion
# Time Complexity: O(2^n) 
# Recursion is Top Down approach, 
# in each recursion depth of the tree we dive, the number of computations will be doubled up
# Space Complexity: O(n) where n is the depth of the recrusion tree

class Solutuion:
    def fib(self, n: int) -> int:
        # our base cases are
        # F(0) = 0, F(1) = 1
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.fib(n-1) + self.fib(n-2)


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
