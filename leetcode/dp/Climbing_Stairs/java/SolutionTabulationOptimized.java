// https://leetcode.com/problems/climbing-stairs/description/
// 70. Climbing Stairs

// Tabulation solution | Space optimized | Bottom-Up | Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(1) because we are not using any extra space for tabulation
class SolutionTabulationOptimized {
    public int climbStairs(int n) {
        // base cases | check the tabulation solution to understand this solution
        int prev = 1; 
        int curr = 2;
        for (int i=3; i<n+1; i++) {
            int res = prev + curr;
            prev = curr;
            curr = res;
        }
        return curr;
    }
    public static void main(String[] args) {
        int n = 45, expected = 1836311903;
        System.out.println("Solution Tabulation Optimized");
        SolutionTabulationOptimized soltabopt = new SolutionTabulationOptimized();
        int actual = soltabopt.climbStairs(n);
        System.out.println(actual);
        
        if (actual == expected) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed: Expected " + expected + ", Actual " + actual);
        }
    }
}
