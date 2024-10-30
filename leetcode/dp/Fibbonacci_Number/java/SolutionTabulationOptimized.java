// https://leetcode.com/problems/fibonacci-number/description/
// 509. Fibonacci Number

// Tabulation solution | Bottom-Up | Dynamic Programming | Space Optimized
// Time Complexity: O(n) because we are using a tabulation array to store the results of the subproblems
// Space Complexity: O(1) because we are not using any extra space
class SolutionTabulationOptimized {
    public int fib(int n) {
        // base cases
        int prev = 0;
        int curr = 1;
        
        // we are done with first two steps, so we start from 2
        for (int i=2; i<n+1; i++) {
            int res = prev + curr;
            prev = curr;
            curr = res;
        }
        return curr;
    }
    public static void main(String[] args) {    
        int n = 10;
        System.out.println("Solution Tabulation Optimized");
        SolutionTabulationOptimized soltabopt = new SolutionTabulationOptimized();
        System.out.println(soltabopt.fib(n));
    }
}
