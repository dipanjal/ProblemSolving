// https://leetcode.com/problems/climbing-stairs/description/
// 70. Climbing Stairs

// Tabulation solution | Bottom-Up | Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(n)
class SolutionTabulation {
    public int climbStairs(int n) {
        // tabulation array to store the results of the subproblems
        int ways[] = new int[n+1];
        // base cases
        ways[1] = 1;
        ways[2] = 2;
        for (int i=3; i<n+1; i++) {
            ways[i] = ways[i-2] + ways[i-1];
        }
        return ways[n];
    }
    public static void main(String[] args) {
        int n = 45, expected = 1836311903;
        System.out.println("Solution Tabulation");
        SolutionTabulation soltab = new SolutionTabulation();
        int actual = soltab.climbStairs(n);
        System.out.println(actual);
        
        if (actual == expected) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}
