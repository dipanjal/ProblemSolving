# https://leetcode.com/problems/climbing-stairs/
# 70. Climbing Stairs

# Recursion + Memoization Solution | Top-Down | Dynamic Programming
# Time Complexity: O(n) because we are using a memoization table to store the results of the subproblems
# Space Complexity: O(n) because we are using a memoization table to store the results of the subproblems
class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {1: 1, 2: 2}
        def findNoOfWays(i) -> int:
            if i in memo:
                return memo[i]
            else:
                memo[i] = findNoOfWays(i-2) + findNoOfWays(i-1)
                return memo[i]
        return findNoOfWays(n)

if __name__ == "__main__":
    n = 45
    expected = 1836311903
    solution = Solution()
    actual = solution.climbStairs(n)
    if actual == expected:
        print("Test Passed")
    else:
        print(f"Test Failed: Expected {expected}, Actual {actual}")