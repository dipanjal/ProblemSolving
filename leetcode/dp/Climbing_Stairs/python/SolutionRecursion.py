# https://leetcode.com/problems/climbing-stairs/
# 70. Climbing Stairs

# Recursive Solution | Top-Down
# Time Complexity: O(2^n) because we are making two recursive calls for each step
# Space Complexity: O(n) because we are using a recursive stack to store the results of the subproblems
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        return self.climbStairs(n - 1) + self.climbStairs(n - 2)

if __name__ == "__main__":
    n = 45
    expected = 1836311903
    solution = Solution()
    actual = solution.climbStairs(n)
    if actual == expected:
        print("Test Passed")
    else:
        print(f"Test Failed: Expected {expected}, Actual {actual}")