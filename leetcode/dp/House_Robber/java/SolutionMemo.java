import java.util.*;

// https://leetcode.com/problems/house-robber/
// 198. House Robber
// Recursive + Memoization | Top Down | Dynamic Programming
// Time Complexity: O(n) -> linear: because we are computing the result for each house only once
// Space Complexity: O(n) -> recursive stack space + O(n) -> memoization hashmap
public class SolutionMemo {
    private int getMax(int i, int[] nums, Map<Integer, Integer> memo) {
        // return if we have already computed the result for current house
        if (memo.containsKey(i)) {
            return memo.get(i);
        } else {
            // otherwise compute max profit from current house
            // ----------------------------REMEMBER----------------------------------------
            // ---- we started from the last house so we will go in backward direction ----
            // ----------------------------------------------------------------------------

            // now we have two options
            // either we can rob the house and go for house at 2 index previous from the current house
            // because we can not rob adjacent houses
            // collect money from current house + rob house at 2 index previous
            int robCurrent = nums[i] + this.getMax(i-2, nums, memo);
            // skip the current house and go for the previous adjacent house
            int skipCurrent = 0 + this.getMax(i-1, nums, memo);
            // cache max profit for current house in the memo
            memo.put(i, Math.max(robCurrent, skipCurrent));
            return memo.get(i);
        }
    }
    
    public int rob(int[] nums) {
        // handling edge case
        if (nums.length == 1) return nums[0];

        // -------------------------------- NOTICE ---------------------------------
        // we will do top down recersive approach, so handling the edge cases first
        // the difference is we are gonna cache the result of each house 
        // so we don't need to recompute max profit for one house multiple times
        // --------------------------------------------------------------------------

        // initalize a hashmash to memoize the result of each house
        Map<Integer, Integer> memo = new HashMap<>();

        // seed with base results
        // base case: if the current house index is 0
        // return the amount of money in the house at index 0 to maximize the profit
        memo.put(0, nums[0]);

        // base case: if the current house index is 1
        // return max amount between house at index 0 and house at index 1
        // we are handling index 1 because we don't want to the array index go bellow 0 or out of lower bounds
        memo.put(1, Math.max(nums[0], nums[1]));

        // start the recursion call from the last house
        return this.getMax(nums.length - 1, nums, memo);
    }

    public static void main(String[] args) {
        // test cases
        List<Map<String, Object>> testCases = new ArrayList<>() {{
            add(Map.of(
                "input", new int[]{1,2,3,1},
                "expected", 4
            ));
            add(Map.of(
                "input", new int[]{2,7,9,3,1},
                "expected", 12
            ));
            add(Map.of(
                "input", new int[]{104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143},
                "expected", 3176
            ));
            add(Map.of(
                "input", new int[]{0},
                "expected", 0
            ));
            add(Map.of(
                "input", new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240},
                "expected", 4173
            ));
        }};

        SolutionMemo sol = new SolutionMemo();
        testCases.stream()
            .filter(testCase -> !(boolean)testCase.getOrDefault("skip", false))
            .forEach(testCase -> {
                int[] input = (int[]) testCase.get("input");
                int expected = (int) testCase.get("expected");
                int actual = sol.rob(input);
                if (actual != expected) {
                    System.out.println("Test Failed: Expected " + expected + ", Actual " + actual);
                } else {
                    System.out.println("Test Passed");
                }
            });
    }
}