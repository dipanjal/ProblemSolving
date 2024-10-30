// https://leetcode.com/problems/fibonacci-number/description/
// 509. Fibonacci Number

class SolutionTabulation {
    // Tabulation solution | Bottom-Up | Dynamic Programming
    // Time Complexity: O(n) because we are using a tabulation array to store the results of the subproblems
    // Space Complexity: O(n) because we are using a tabulation array to store the results of the subproblems
    public int fib(int n) {
        // dp array to keep the fibbonacci sumations
        // n+1 for keeping all n numbers of results
        int sums[] = new int[n+1];
        // base cases
        sums[0] = 0;
        sums[1] = 1;
        for (int i=2; i<n+1; i++) {
            sums[i] = sums[i-2] + sums[i-1];
        }
        return sums[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Solution Tabulation");
        SolutionTabulation soltab = new SolutionTabulation();
        System.out.println(soltab.fib(n));
    }
}
