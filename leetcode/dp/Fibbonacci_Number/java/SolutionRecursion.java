// https://leetcode.com/problems/fibonacci-number/description/
// 509. Fibonacci Number

class SolutionRecursion {
    // Recursive solution | Top-Down
    // Time Complexity: O(2^n) because each call to fib(n) makes two more calls to fib(n-1) and fib(n-2)    
    // Space Complexity: O(n) because the maximum depth of the recursion tree is n
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Solution Recursion");
        SolutionRecursion solrecur = new SolutionRecursion();
        System.out.println(solrecur.fib(n));
    }
}
