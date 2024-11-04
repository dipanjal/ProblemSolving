import java.util.*;

// https://leetcode.com/problems/house-robber/
// 198. House Robber
// Tabulation + Space Optimized | Iterative Approach | Bottom Up | Dynamic Programming
// Time Complexity: O(n) -> linear: because we are computing the result for each house only once
// Space Complexity: O(1) -> track result of previous 2 houses using 2 variables
public class SolutionTabulationOptimized {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // instead of array we will be using two variables
        // to keep track of result of previous two houses
        // that's all we need

        // assume this is the house at index 0
        int prev2 = nums[0];
        // house at index 1
        int prev1 = Math.max(nums[0], nums[1]);
        // now start from index 2
        for (int i=2; i<nums.length; i++) {
            int maxCurr = Math.max(
                nums[i] + prev2,  // rob the current house + add profit from 2 house back (non adj)
                0 + prev1  // skip current house and rob adj house
            );
            // track the result of current house and previous
            prev2 = prev1;
            prev1 = maxCurr;
        }
        // return the last value which is the ultimate result
        return prev1;
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

        SolutionTabulationOptimized sol = new SolutionTabulationOptimized();
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