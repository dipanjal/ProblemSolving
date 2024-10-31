# https://leetcode.com/problems/climbing-stairs/
# 70. Climbing Stairs

# Tabulation Solution | Bottom-Up | Dynamic Programming
# Time Complexity: O(n) because we are iterating through the array once
# Space Complexity: O(n) because we are using an array to store the results of the subproblems
class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0] * (n+1)
        # base cases
        dp[1] = 1 # first stair: can climb in only one way
        dp[2] = 2 # sec stair: 2 ways: (1+1) or 2 at a time
        # done upto index 2, star wil index 3
        for i in range(3, n+1):
            dp[i] = dp[i-2] + dp[i-1]
        return dp[n]

if __name__ == "__main__":
    n = 45
    expected = 1836311903
    solution = Solution()
    actual = solution.climbStairs(n)
    if actual == expected:
        print("Test Passed")
    else:
        print(f"Test Failed: Expected {expected}, Actual {actual}")