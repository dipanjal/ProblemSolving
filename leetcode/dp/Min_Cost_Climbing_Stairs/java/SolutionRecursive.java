import java.util.*;

// https://leetcode.com/problems/min-cost-climbing-stairs/
// 746. Min Cost Climbing Stairs
// Recursive solution | Top-Down approach
// Time Complexity: O(2^n) because we are making 2 recursive calls for each recursive call
// Space Complexity: O(n) because of the recursive stack space

class SolutionRecursive {    
    // calculate and return min cost for the given ith stair
    private int getMinCost(int i, int[] cost) {
        // base cases
        // we can start from 0th or 1th stair, 
        // so no need to pay any cost for climbing them
        if (i == 0) return 0;
        if (i == 1) return 0;

        // cost for climbing down 1 stair from the current ith stair
        int costForOneStepBellow = cost[i-1] + this.getMinCost(i-1, cost);
        // cost for climbing down 2 stairs from the current ith stair
        int costForTwoStepsBellow = cost[i-2] + this.getMinCost(i-2, cost);
        // return the minimum cost from both of the options
        // notice, we are making 2 recursion calls for each recursive calls
        return Math.min(costForOneStepBellow, costForTwoStepsBellow);
    }

    public int minCostClimbingStairs(int[] cost) {
        // the length of the cost is equal to the total number to stairs 
        // we need to climb to reach at the top of the floor
        // since recursion is a top-down apparoch, we will start from the last stair
        return this.getMinCost(cost.length, cost);
    }

    public static void main(String[] args) {
        // test cases
        List<Map<String, Object>> testCases = new ArrayList<>() {{
            add(Map.of(
                "input", new int[]{1,100,1,1,1,100,1,1,100,1}, 
                "expected", 6
            ));
            add(Map.of(
                "input", new int[]{10,15}, 
                "expected", 10
            ));
            add(Map.of(
                "input", new int[]{10,15,20},
                "expected", 15
            ));
        }};

        SolutionRecursive sol = new SolutionRecursive();
        testCases.forEach(testCase -> {
            int[] input = (int[]) testCase.get("input");
            int expected = (int) testCase.get("expected");
            int actual = sol.minCostClimbingStairs(input);
            if (actual != expected) {
                System.out.println("Test Failed: Expected " + expected + ", Actual " + actual);
            } else {
                System.out.println("Test Passed");
            }
        });
    }
}