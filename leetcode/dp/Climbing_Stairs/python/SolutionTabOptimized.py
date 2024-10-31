# https://leetcode.com/problems/climbing-stairs/
# 70. Climbing Stairs

# Tabulation Memory Optimized Solution | Bottom-Up | Dynamic Programming
# Time Complexity: O(n) because we are iterating through the n numbers once
# Space Complexity: O(1) because we are not using any extra space to store the result of previous two steps
# This is the optimized version of the Tabulation Solution
class Solution:
    def climbStairs(self, n: int) -> int:
        # base cases
        prev, curr = 1, 2
        for i in range(3, n+1):
            res = prev + curr
            prev, curr = curr, res
        return curr

if __name__ == "__main__":
    n = 45
    expected = 1836311903
    solution = Solution()
    actual = solution.climbStairs(n)
    if actual == expected:
        print("Test Passed")
    else:
        print(f"Test Failed: Expected {expected}, Actual {actual}")