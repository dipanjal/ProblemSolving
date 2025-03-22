class SolutionBruteForce {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}, expected = {0, 1};
        int target = 9;
        System.out.println("Solution Brute Force");
        SolutionBruteForce sol = new SolutionBruteForce();
        int[] actual = sol.twoSum(nums, target);
        System.out.println(actual[0] + " " + actual[1]);
        
        if (actual[0] == expected[0] && actual[1] == expected[1]) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed: Expected " + expected[0] + " " + expected[1] + ", Actual " + actual[0] + " " + actual[1]);
        }
    }
}