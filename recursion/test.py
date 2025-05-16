def countNumOfSubsequence(nums: list[int], target: int):
    def getCount(i: int, sum: int):
        # when the sum is already bigger than the target
        # no need to go further
        if sum > target:
            return 0
        if i == len(target):
            return 1

    count = getCount(0, 0)

if __name__ == "__main__":
    print(f"No of Subsequences: {countNumOfSubsequence(nums=[1, 2, 1], k=2)}")

# [1, 1] = 2
# [2] = 2