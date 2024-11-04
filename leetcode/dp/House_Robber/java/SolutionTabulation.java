import java.util.*;

// https://leetcode.com/problems/house-robber/
// 198. House Robber
// Tabulation | Iterative Approach | Bottom Up | Dynamic Programming
// Time Complexity: O(n) -> linear: because we are computing the result for each house only once
// Space Complexity: O(n) -> using array to store result for all the previous houses
public class SolutionTabulation {
    public int rob(int[] nums) {
        // handle edge cases
        if (nums.length == 1) return nums[0];

        // create a DP array to save the max profits from the houses
        int[] maxProfits = new int[nums.length];

        // seed with base results
        // base case: if the current house index is 0
        // to maximize the profit, return the amount of money in the house at index 0
        maxProfits[0] = nums[0];

        // base case: if the current house index is 1
        // return max amount between house at index 0 and house at index 1
        // we are handling index 1 because we don't want to the array index go bellow 0 or out of lower bounds
        maxProfits[1] = Math.max(nums[0], nums[1]);

        // done with our first two indexes
        // start with index 2
        for (int i=2; i<nums.length; i++) {
            // now we have two options
            // either we can rob the house and go for house at 2 index previous from the current house
            // because we can not rob adjacent houses
            // collect money from current house + rob house at 2 index previous
            int robCurrent = nums[i] + maxProfits[i-2];
            
            // skip the current house and go for the previous adjacent house
            int skipCurrent = 0 + maxProfits[i-1];

            // save max profit for current house by selecting max amount between these two results
            maxProfits[i] = Math.max(robCurrent, skipCurrent);
        }
        // finally return the last value which is the ultimate max amount
        return maxProfits[nums.length - 1];
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

        SolutionTabulation sol = new SolutionTabulation();
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