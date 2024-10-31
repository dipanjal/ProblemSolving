// https://leetcode.com/problems/climbing-stairs/description/
// 70. Climbing Stairs

import java.util.HashMap;
import java.util.Map;

// Recursive + Memoization | Top-Down | Dynamic Programming
// Time Complexity: O(n) because we are using a memoization array to store the results of the subproblems
// Space Complexity: O(n) because we are using a memoization array to store the results of the subproblems
class SolutionMemo {
    // memoization map to store the results of the subproblems
    Map<Integer, Integer> memo;
    public SolutionMemo() {
        this.memo = new HashMap<>();
        // adding base cases to the memoization map
        this.memo.put(1, 1);
        this.memo.put(2, 2);
    }
    public int climbStairs(int n) {
        if (this.memo.containsKey(n)) {
            return this.memo.get(n);
        } else {
            int res = climbStairs(n-2) + climbStairs(n-1);
            this.memo.put(n, res);
            return res;
        }
    }
    public static void main(String[] args) {
        int n = 45, expected = 1836311903;
        System.out.println("Solution Memo");
        SolutionMemo solmemo = new SolutionMemo();
        int actual = solmemo.climbStairs(n);
        System.out.println(actual);
        
        if (actual == expected) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed: Expected " + expected + ", Actual " + actual);
        }
    }
}
