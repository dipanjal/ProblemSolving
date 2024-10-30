// https://leetcode.com/problems/climbing-stairs/description/
// 70. Climbing Stairs

// Recursive solution | Top-Down
// Time Complexity: O(2^n) because we are making two recursive calls for each step
// Space Complexity: O(n) because we are using the call stack to store the recursive calls
class SolutionRecursion {
    public int climbStairs(int n) {
        // bases cases
        // one stair can be climbed in only one way
        if (n == 1) return 1;
        // two stairs can be climbed in two ways
        // 1 + 1 steps | 2 steps at once
        if (n == 2) return 2;
        return climbStairs(n-2) + climbStairs(n-1);
    }
    public static void main(String[] args) {
        int n = 45;
        System.out.println("Solution Recursion");
        SolutionRecursion solrecur = new SolutionRecursion();
        System.out.println(solrecur.climbStairs(n));
    }
}
