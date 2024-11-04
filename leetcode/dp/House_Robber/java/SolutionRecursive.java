import java.util.*;

// https://leetcode.com/problems/house-robber/
// 198. House Robber
// Recursive | Top Down | Brute Force
// Time Complexity: O(2^n) -> exponential: because we are making two recursive calls for n number of houses
// Space Complexity: O(n) -> recursive stack space
public class SolutionRecursive {
    // i = current house index
    // nums = array of amounts of money in each house
    private int getMax(int i, int[] nums) {
        // base case: if the current house index is 1
        // return max amount between house at index 0 and house at index 1
        // we are handing index 1 because we don't want to handle array index is bellow 0 or out of bounds
        if (i == 1) return Math.max(nums[0], nums[1]);
        // base case: if the current house index is 0
        // return the amount of money in the house at index 0 to maximize the profit
        if (i == 0) return nums[0];
        
        // ----------------------------REMEMBER----------------------------------------
        // ---- we started from the last house so we will go in backward direction ----
        // ----------------------------------------------------------------------------

        // now we have two options
        // either we can rob the house and go for house at 2 index previous from the current house
        // because we can not rob adjacent houses
        // collect money from current house + rob house at 2 index previous
        int rob_current = nums[i] + getMax(i-2, nums);
        // skip the current house and go for the previous adjacent house
        int skip_current = 0 + getMax(i-1, nums);
        // return the max profit between these values
        return Math.max(rob_current, skip_current);
    }


    public int rob(int[] nums) {
        // we are doing top down recursion
        // so we will start from the last house index
        return getMax(nums.length - 1, nums);
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

        SolutionRecursive sol = new SolutionRecursive();
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
