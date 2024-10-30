// https://leetcode.com/problems/fibonacci-number/description/
// 509. Fibonacci Number

import java.util.Map;
import java.util.HashMap;

// Memoization is a technique used to optimize the performance of recursive algorithms 
// by storing the results of expensive function calls 
// and reusing them when the same inputs occur again.
public class SolutionMemo {
    // Recursive + Memoization solution | Top-Down | Dynamic Programming
    // Time Complexity: O(n) because we are using a memoization array to store the results of the subproblems
    // Space Complexity: O(n) because we are using a memoization array to store the results of the subproblems 
    private Map<Integer, Integer> memo;
    public SolutionMemo() {
        this.memo = new HashMap<>();
        // add base cases
        this.memo.put(0, 0);
        this.memo.put(1, 1);
    }
    public int fib(int n) {
        if (this.memo.containsKey(n)) {
            return this.memo.get(n);
        } else {
            int res = fib(n-2) + fib(n-1);
            this.memo.put(n, res);
            return res;
        }
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Solution Memoization");
        SolutionMemo solmemo = new SolutionMemo();
        System.out.println(solmemo.fib(n));
    }
}
